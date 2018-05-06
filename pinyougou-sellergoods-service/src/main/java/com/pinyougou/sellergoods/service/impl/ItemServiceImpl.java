package com.pinyougou.sellergoods.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pinyougou.mapper.TbItemMapper;
import com.pinyougou.pojo.TbItem;
import com.pinyougou.pojo.TbItemExample;
import com.pinyougou.pojo.TbItemExample.Criteria;
import com.pinyougou.sellergoods.service.ItemService;

import entity.PageResult;

/**
 * 服务实现层
 * 
 * @author Administrator
 *
 */
@Service
@Transactional
public class ItemServiceImpl implements ItemService {

	@Autowired
	private TbItemMapper itemMapper;

	/**
	 * 查询全部
	 */
	@Override
	public List<TbItem> findAll() {
		return itemMapper.selectByExample(null);
	}

	/**
	 * 按分页查询
	 */
	@Override
	public PageResult findPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		Page<TbItem> page = (Page<TbItem>) itemMapper.selectByExample(null);
		return new PageResult(page.getTotal(), page.getResult());
	}

	/**
	 * 增加
	 */
	@Override
	public void add(TbItem item) {
		itemMapper.insert(item);
	}

	/**
	 * 修改
	 */
	@Override
	public void update(TbItem item) {
		itemMapper.updateByPrimaryKey(item);
	}

	/**
	 * 根据ID获取实体
	 * 
	 * @param id
	 * @return
	 */
	@Override
	public TbItem findOne(Long id) {
		return itemMapper.selectByPrimaryKey(id);
	}

	/**
	 * 批量删除
	 */
	@Override
	public void delete(Long[] ids) {
		for (Long id : ids) {
			itemMapper.deleteByPrimaryKey(id);
		}
	}

	@Override
	public PageResult findPage(TbItem item, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);

		TbItemExample example = new TbItemExample();
		Criteria criteria = example.createCriteria();

		if (item != null) {
			if (item.getTitle() != null && item.getTitle().length() > 0) {
				criteria.andTitleLike("%" + item.getTitle() + "%");
			}
			if (item.getSellPoint() != null && item.getSellPoint().length() > 0) {
				criteria.andSellPointLike("%" + item.getSellPoint() + "%");
			}
			if (item.getBarcode() != null && item.getBarcode().length() > 0) {
				criteria.andBarcodeLike("%" + item.getBarcode() + "%");
			}
			if (item.getImage() != null && item.getImage().length() > 0) {
				criteria.andImageLike("%" + item.getImage() + "%");
			}
			if (item.getStatus() != null && item.getStatus().length() > 0) {
				criteria.andStatusLike("%" + item.getStatus() + "%");
			}
			if (item.getItemSn() != null && item.getItemSn().length() > 0) {
				criteria.andItemSnLike("%" + item.getItemSn() + "%");
			}
			if (item.getIsDefault() != null && item.getIsDefault().length() > 0) {
				criteria.andIsDefaultLike("%" + item.getIsDefault() + "%");
			}
			if (item.getSellerId() != null && item.getSellerId().length() > 0) {
				criteria.andSellerIdLike("%" + item.getSellerId() + "%");
			}
			if (item.getCartThumbnail() != null && item.getCartThumbnail().length() > 0) {
				criteria.andCartThumbnailLike("%" + item.getCartThumbnail() + "%");
			}
			if (item.getCategory() != null && item.getCategory().length() > 0) {
				criteria.andCategoryLike("%" + item.getCategory() + "%");
			}
			if (item.getBrand() != null && item.getBrand().length() > 0) {
				criteria.andBrandLike("%" + item.getBrand() + "%");
			}
			if (item.getSpec() != null && item.getSpec().length() > 0) {
				criteria.andSpecLike("%" + item.getSpec() + "%");
			}
			if (item.getSeller() != null && item.getSeller().length() > 0) {
				criteria.andSellerLike("%" + item.getSeller() + "%");
			}

		}

		Page<TbItem> page = (Page<TbItem>) itemMapper.selectByExample(example);
		return new PageResult(page.getTotal(), page.getResult());
	}

}
