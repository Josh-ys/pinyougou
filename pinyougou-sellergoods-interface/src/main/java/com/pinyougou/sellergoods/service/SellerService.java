package com.pinyougou.sellergoods.service;

import java.util.List;
import com.pinyougou.pojo.TbSeller;

import entity.PageResult;

/**
 * 商家服务层接口
 * 
 * @author Administrator
 *
 */
public interface SellerService {

	/**
	 * 返回全部列表
	 * 
	 * @return
	 */
	public List<TbSeller> findAll();

	/**
	 * 返回分页列表
	 * 
	 * @return
	 */
	public PageResult findPage(int pageNum, int pageSize);

	/**
	 * 增加
	 */
	public void add(TbSeller seller);

	/**
	 * 修改
	 */
	public void update(TbSeller seller);

	/**
	 * 根据ID获取实体
	 * 
	 * @param id
	 * @return
	 */
	public TbSeller findOne(String id);

	/**
	 * 批量删除
	 * 
	 * @param ids
	 */
	public void delete(String[] ids);

	/**
	 * 分页
	 * 
	 * @param pageNum
	 *            当前页 码
	 * @param pageSize
	 *            每页记录数
	 * @return
	 */
	public PageResult findPage(TbSeller seller, int pageNum, int pageSize);

	/**
	 * 修改审核状态
	 */
	public void updateStatus(String sellerId, String status);
}
