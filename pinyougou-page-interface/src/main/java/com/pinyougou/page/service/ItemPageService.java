package com.pinyougou.page.service;

/**
 * 商品详细页接口
 * 
 * @author Reasonless
 *
 */
public interface ItemPageService {

	/**
	 * 生成商品详细页
	 */
	boolean genItemHtml(Long goodsId);

	/**
	 * 删除商品详细页
	 * @param
	 * @return
	 */
	public boolean deleteItemHtml(Long[] goodsIds);

}
