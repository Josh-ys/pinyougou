package com.pinyougou.solrutils;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.pinyougou.mapper.TbItemMapper;
import com.pinyougou.pojo.TbItem;
import com.pinyougou.pojo.TbItemExample;
import com.pinyougou.pojo.TbItemExample.Criteria;

@Component
public class SolrUtils {

	@Autowired
	private TbItemMapper itemMapper;

	@Autowired
	private SolrTemplate solrTemplate;

	/**
	 * 导入商品数据
	 */
	@SuppressWarnings("all")
	public void importItemData() {
		TbItemExample example = new TbItemExample();
		Criteria criteria = example.createCriteria();
		criteria.andStatusEqualTo("1");// 已审核
		List<TbItem> byExample = itemMapper.selectByExample(example);
		System.out.println("===商品列表===");
		for (TbItem tbItem : byExample) {
			// 将spec字段中的json字符串转换为map
			Map specMap = JSON.parseObject(tbItem.getSpec(), Map.class);
			// 给带注解的字段赋值
			tbItem.setSpecMap(specMap);
		}
		solrTemplate.saveBeans(byExample);
		solrTemplate.commit();
		System.out.println("===结束===");
	}

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath*:spring/applicationContext*.xml");
		SolrUtils solrUtils = (SolrUtils) context.getBean("solrUtils");
		solrUtils.importItemData();
	}
}
