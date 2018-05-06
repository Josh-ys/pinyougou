package com.pinyougou.manager.controller;

import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.pojo.TbBrand;
import com.pinyougou.sellergoods.service.BrandService;

import entity.PageResult;
import entity.Result;

/**
 * 品牌controller
 * 
 * @author Reasonless
 *
 */
@RestController // 相当于Controller加上ResponseBody
@RequestMapping("/brand")
public class BrandController {

	@Reference // dubbo的远程注入
	private BrandService brandService;

	/**
	 * 品牌的添加
	 * 
	 * @param tbBrand
	 * @return
	 */
	@RequestMapping("/add")
	public Result addBrand(@RequestBody TbBrand tbBrand) {
		try {
			Pattern pattern = Pattern.compile("^[A-Za-z]+$");
			Matcher matcher = pattern.matcher(tbBrand.getFirstChar());
			if (tbBrand.getFirstChar().length() != 1 || !matcher.matches()) {
				return new Result(false, "首字母必须为单个字母!");
			}
			brandService.addBrand(tbBrand);
			return new Result(true, "品牌添加成功！");
		} catch (Exception e) {
			return new Result(false, "品牌添加失败！添加的品牌已存在");
		}
	}

	/**
	 * 根据id查询对应的品牌
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping("/findOne")
	public TbBrand findOne(Long id) {
		return brandService.findOne(id);
	}

	/**
	 * 更新品牌
	 * 
	 * @param tbBrand
	 * @return
	 */
	@RequestMapping("/update")
	public Result updateTbBrand(@RequestBody TbBrand tbBrand) {
		try {
			brandService.updateTbBrand(tbBrand);
			return new Result(true, "品牌修改成功！");
		} catch (RuntimeException e) {
			return new Result(false, "品牌修改失败！");
		}
	}

	/**
	 * 品牌删除
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping("/delete")
	public Result deleteById(Long[] ids) {
		try {
			brandService.deleteTbBrand(ids);
			return new Result(true, "品牌删除成功！");
		} catch (RuntimeException e) {
			return new Result(false, "品牌删除失败！");
		}
	}

	/**
	 * 带条件的分页查询以及页面加载的时候分页
	 * 
	 * @param tbBrand
	 * @param page
	 * @param size
	 * @return
	 */
	@RequestMapping("/search")
	public PageResult search(@RequestBody TbBrand tbBrand, Integer page, Integer size) {
		return brandService.findPage(tbBrand, page, size);
	}

	/**
	 * 下拉列表的返回
	 * 
	 * @return
	 */
	@RequestMapping("/selectOptionList")
	public List<Map> selectOptionList() {
		return brandService.selectOptionList();
	}
}
