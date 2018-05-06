package com.pinyougou.sellergoods.service;

import java.util.List;
import java.util.Map;

import com.pinyougou.pojo.TbBrand;

import entity.PageResult;

/**
 * 品牌服务层接口
 * 
 * @author Reasonless
 *
 */
public interface BrandService {


	/**
	 * 品牌添加
	 * 
	 * @param tbBrand
	 */
	void addBrand(TbBrand tbBrand);

	/**
	 * 根据id查询对应的数据
	 */
	TbBrand findOne(Long id);

	/**
	 * 品牌信息的更新
	 * 
	 * @param tbBrand
	 */
	void updateTbBrand(TbBrand tbBrand);
	
	/**
	 * 品牌删除
	 * @param ids
	 */
	void deleteTbBrand(Long[] ids);
	
	/**
	 * 根据条件查询，以及页面加载的时候分页
	 * @param tbBrand
	 * @param page
	 * @param pageSize
	 * @return
	 */
	PageResult findPage(TbBrand tbBrand,Integer page, Integer pageSize);
	
	/**
	 * 返回下拉列表
	 * @return
	 */
	List<Map> selectOptionList();
}
