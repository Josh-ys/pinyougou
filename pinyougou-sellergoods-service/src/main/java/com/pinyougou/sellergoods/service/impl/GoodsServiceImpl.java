package com.pinyougou.sellergoods.service.impl;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pinyougou.mapper.TbBrandMapper;
import com.pinyougou.mapper.TbGoodsDescMapper;
import com.pinyougou.mapper.TbGoodsMapper;
import com.pinyougou.mapper.TbItemCatMapper;
import com.pinyougou.mapper.TbItemMapper;
import com.pinyougou.mapper.TbSellerMapper;
import com.pinyougou.pojo.TbBrand;
import com.pinyougou.pojo.TbGoods;
import com.pinyougou.pojo.TbGoodsDesc;
import com.pinyougou.pojo.TbGoodsExample;
import com.pinyougou.pojo.TbGoodsExample.Criteria;
import com.pinyougou.pojo.TbItem;
import com.pinyougou.pojo.TbItemCat;
import com.pinyougou.pojo.TbItemExample;
import com.pinyougou.pojo.TbSeller;
import com.pinyougou.pojogroup.Goods;
import com.pinyougou.sellergoods.service.GoodsService;

import entity.PageResult;

/**
 * 服务实现层
 * 
 * @author Administrator
 *
 */
@Service(timeout = 100000)
@Transactional
public class GoodsServiceImpl implements GoodsService {

	@Autowired
	private TbGoodsMapper goodsMapper;

	@Autowired
	private TbGoodsDescMapper tbGoodsDescMapper;

	/**
	 * 查询全部
	 */
	@Override
	public List<TbGoods> findAll() {
		return goodsMapper.selectByExample(null);
	}

	/**
	 * 按分页查询
	 */
	@Override
	public PageResult findPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		Page<TbGoods> page = (Page<TbGoods>) goodsMapper.selectByExample(null);
		return new PageResult(page.getTotal(), page.getResult());
	}

	@Autowired
	private TbItemMapper itemMapper;

	@Autowired
	private TbBrandMapper brandMapper;

	@Autowired
	private TbItemCatMapper catMapper;

	@Autowired
	private TbSellerMapper sellerMapper;

	/**
	 * 增加
	 */
	@Override
	public void add(Goods goods) {
		goods.getGoods().setAuditStatus("0");// 设置未申请状态
		goods.getGoods().setIsMarketable("1");
		goodsMapper.insert(goods.getGoods());
		goods.getGoodsDesc().setGoodsId(goods.getGoods().getId());// 设置ID
		tbGoodsDescMapper.insert(goods.getGoodsDesc());// 插入商品扩展数据
		// 添加规格
		addItemList(goods);

	}

	private void addItemList(Goods goods) {
		if ("1".equals(goods.getGoods().getIsEnableSpec())) {
			List<TbItem> list = goods.getItemList();
			// 标题
			String title = goods.getGoods().getGoodsName();
			for (TbItem tbItem : list) {
				Map<String, Object> map = JSON.parseObject(tbItem.getSpec());
				for (String Item : map.keySet()) {
					title += " " + map.get(Item);
				}
				tbItem.setTitle(title);
				setTbItemValue(goods, tbItem);
				itemMapper.insert(tbItem);
			}
		} else {
			// 不启用规格
			TbItem tbItem = new TbItem();
			tbItem.setTitle(goods.getGoods().getGoodsName());
			tbItem.setPrice(goods.getGoods().getPrice());
			tbItem.setStatus("1");
			tbItem.setIsDefault("1");
			tbItem.setNum(999);
			tbItem.setSpec("{}");
			setTbItemValue(goods, tbItem);
			itemMapper.insert(tbItem);
		}
	}

	// 属性的设置
	private void setTbItemValue(Goods goods, TbItem tbItem) {
		tbItem.setGoodsId(goods.getGoods().getId());// 商品SPU编号
		tbItem.setCategoryid(goods.getGoods().getCategory3Id());//// 商品分类编号(3级)
		tbItem.setSellerId(goods.getGoods().getSellerId());// 商家编号
		tbItem.setCreateTime(new Date());// 创建日期
		tbItem.setUpdateTime(new Date());// 修改日期
		// 分类名称
		TbItemCat tbItemCat = catMapper.selectByPrimaryKey(goods.getGoods().getCategory3Id());
		tbItem.setCategory(tbItemCat.getName());
		// 品牌名称
		TbBrand tbBrand = brandMapper.selectByPrimaryKey(goods.getGoods().getBrandId());
		tbItem.setBrand(tbBrand.getName());
		// 商家名称
		TbSeller tbSeller = sellerMapper.selectByPrimaryKey(goods.getGoods().getSellerId());
		tbItem.setSeller(tbSeller.getNickName());
		// 图片地址（取spu的第一个图片）
		List<Map> array = JSON.parseArray(goods.getGoodsDesc().getItemImages(), Map.class);
		if (array.size() > 0) {
			tbItem.setImage((String) array.get(0).get("url"));
		}
	}

	/**
	 * 修改
	 */
	@Override
	public void update(Goods goods) {
		goods.getGoods().setAuditStatus("0");// 设置未申请状态:如果是经过修改的商品，需要重新设置状态
		// 保存商品表
		goodsMapper.updateByPrimaryKey(goods.getGoods());
		// 保存商品扩展表
		tbGoodsDescMapper.updateByPrimaryKey(goods.getGoodsDesc());
		// 删除原有的sku列表数据
		TbItemExample example = new TbItemExample();
		com.pinyougou.pojo.TbItemExample.Criteria criteria = example.createCriteria();
		criteria.andGoodsIdEqualTo(goods.getGoods().getId());
		itemMapper.deleteByExample(example);
		// 添加新的sku列表数据
		addItemList(goods);
	}

	/**
	 * 根据ID获取实体
	 * 
	 * @param id
	 * @return
	 */
	@Override
	public Goods findOne(Long id) {
		Goods goods = new Goods();
		TbGoods tbGoods = goodsMapper.selectByPrimaryKey(id);
		goods.setGoods(tbGoods);

		TbGoodsDesc tbGoodsDesc = tbGoodsDescMapper.selectByPrimaryKey(id);
		goods.setGoodsDesc(tbGoodsDesc);

		TbItemExample example = new TbItemExample();
		com.pinyougou.pojo.TbItemExample.Criteria criteria = example.createCriteria();
		criteria.andGoodsIdEqualTo(id);
		List<TbItem> itemList = itemMapper.selectByExample(example);
		goods.setItemList(itemList);
		return goods;
	}

	/**
	 * 批量删除
	 */
	@Override
	public void delete(Long[] ids) {
		for (Long id : ids) {
			TbGoods tbGoods = goodsMapper.selectByPrimaryKey(id);
			tbGoods.setIsDelete("1");
			goodsMapper.updateByPrimaryKey(tbGoods);
		}
	}

	@Override
	public PageResult findPage(TbGoods goods, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);

		TbGoodsExample example = new TbGoodsExample();
		Criteria criteria = example.createCriteria();

		criteria.andIsDeleteIsNull();// 非删除状态
		if (goods != null) {
			if (goods.getSellerId() != null && goods.getSellerId().length() > 0) {
				criteria.andSellerIdEqualTo(goods.getSellerId());
			}
			if (goods.getGoodsName() != null && goods.getGoodsName().length() > 0) {
				criteria.andGoodsNameLike("%" + goods.getGoodsName() + "%");
			}
			if (goods.getAuditStatus() != null && goods.getAuditStatus().length() > 0) {
				criteria.andAuditStatusLike("%" + goods.getAuditStatus() + "%");
			}
			if (goods.getIsMarketable() != null && goods.getIsMarketable().length() > 0) {
				criteria.andIsMarketableLike("%" + goods.getIsMarketable() + "%");
			}
			if (goods.getCaption() != null && goods.getCaption().length() > 0) {
				criteria.andCaptionLike("%" + goods.getCaption() + "%");
			}
			if (goods.getSmallPic() != null && goods.getSmallPic().length() > 0) {
				criteria.andSmallPicLike("%" + goods.getSmallPic() + "%");
			}
			if (goods.getIsEnableSpec() != null && goods.getIsEnableSpec().length() > 0) {
				criteria.andIsEnableSpecLike("%" + goods.getIsEnableSpec() + "%");
			}
			if (goods.getIsDelete() != null && goods.getIsDelete().length() > 0) {
				criteria.andIsDeleteLike("%" + goods.getIsDelete() + "%");
			}

		}

		Page<TbGoods> page = (Page<TbGoods>) goodsMapper.selectByExample(example);
		return new PageResult(page.getTotal(), page.getResult());
	}

	/**
	 * 更改状态方法的实现
	 */
	@Override
	public void updateStatus(Long[] ids, String status) {
		for (Long id : ids) {
			TbGoods tbGoods = goodsMapper.selectByPrimaryKey(id);
			tbGoods.setAuditStatus(status);
			goodsMapper.updateByPrimaryKey(tbGoods);
		}
	}

	/**
	 * 上下架
	 */
	@Override
	public void updateIsMarketable(Long[] ids, String isMarketable) {
		for (Long id : ids) {
			TbGoods tbGoods = goodsMapper.selectByPrimaryKey(id);
			if (tbGoods.getAuditStatus().equals("1")) {
				tbGoods.setIsMarketable(isMarketable);
				goodsMapper.updateByPrimaryKey(tbGoods);
			} else {
				throw new RuntimeException();
			}
		}
	}

	@Override
	public List<TbItem> findItemListByGoodsIdandStatus(Long[] goodsIds, String status) {
		TbItemExample example = new TbItemExample();
		com.pinyougou.pojo.TbItemExample.Criteria criteria = example.createCriteria();
		criteria.andGoodsIdIn(Arrays.asList(goodsIds));
		criteria.andStatusEqualTo(status);
		List<TbItem> byExample = itemMapper.selectByExample(example);
		return byExample;
	}
}
