package com.pinyougou.sellergoods.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pinyougou.mapper.TbBrandMapper;
import com.pinyougou.pojo.TbBrand;
import com.pinyougou.pojo.TbBrandExample;
import com.pinyougou.pojo.TbBrandExample.Criteria;
import com.pinyougou.sellergoods.service.BrandService;

import entity.PageResult;

/**
 * 品牌服务层接口的实现
 * 
 * @author Reasonless
 *
 */
@Service
@Transactional
public class BrandServiceImpl implements BrandService {

	@Autowired
	private TbBrandMapper tbBrandMapper;

	/**
	 * 品牌添加的实现
	 */
	@Override
	public void addBrand(TbBrand tbBrand) {
		tbBrandMapper.insert(tbBrand);
	}

	/**
	 * 查询单个品牌的实现
	 */
	@Override
	public TbBrand findOne(Long id) {
		return tbBrandMapper.selectByPrimaryKey(id);
	}

	/**
	 * 品牌更新的实现
	 */
	@Override
	public void updateTbBrand(TbBrand tbBrand) {
		tbBrandMapper.updateByPrimaryKey(tbBrand);
	}

	/**
	 * 品牌删除的实现
	 */
	@Override
	public void deleteTbBrand(Long[] ids) {
		for (Long id : ids) {
			tbBrandMapper.deleteByPrimaryKey(id);
		}
	}

	/**
	 * 带条件查询的实现以及页面加载的时候分页
	 */
	@Override
	public PageResult findPage(TbBrand tbBrand, Integer page, Integer pageSize) {
		TbBrandExample example = new TbBrandExample();
		Criteria criteria = example.createCriteria();
		if (tbBrand != null) {
			if (tbBrand.getName() != null && tbBrand.getName().length() > 0) {
				criteria.andNameLike("%" + tbBrand.getName() + "%");
			}
			if (tbBrand.getFirstChar() != null && tbBrand.getFirstChar().length() > 0) {
				criteria.andFirstCharLike("%" + tbBrand.getFirstChar() + "%");
			}
		}
		PageHelper.startPage(page, pageSize);
		List<TbBrand> list = tbBrandMapper.selectByExample(example);
		PageInfo<TbBrand> pageInfo = new PageInfo<>(list);
		return new PageResult(pageInfo.getTotal(), pageInfo.getList());
	}

	/**
	 * 返回下拉列表的实现
	 */
	@Override
	public List<Map> selectOptionList() {
		return tbBrandMapper.selectOptionList();
	}
}
