package com.pinyougou.search.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.core.query.Criteria;
import org.springframework.data.solr.core.query.FilterQuery;
import org.springframework.data.solr.core.query.GroupOptions;
import org.springframework.data.solr.core.query.HighlightOptions;
import org.springframework.data.solr.core.query.HighlightQuery;
import org.springframework.data.solr.core.query.Query;
import org.springframework.data.solr.core.query.SimpleFilterQuery;
import org.springframework.data.solr.core.query.SimpleHighlightQuery;
import org.springframework.data.solr.core.query.SimpleQuery;
import org.springframework.data.solr.core.query.SolrDataQuery;
import org.springframework.data.solr.core.query.result.GroupEntry;
import org.springframework.data.solr.core.query.result.GroupPage;
import org.springframework.data.solr.core.query.result.GroupResult;
import org.springframework.data.solr.core.query.result.HighlightEntry;
import org.springframework.data.solr.core.query.result.HighlightPage;

import com.alibaba.dubbo.config.annotation.Service;
import com.pinyougou.pojo.TbItem;
import com.pinyougou.search.service.ItemSearchService;

@Service(timeout = 5000)
public class ItemSearchServiceImpl implements ItemSearchService {

	@Autowired
	private SolrTemplate solrTemplate;

	@Override
	public Map<String, Object> search(Map searchMap) {
		// 关键字空格处理
		String keywords = (String) searchMap.get("keywords");
		searchMap.put("keywords", keywords.replace(" ", ""));
		Map<String, Object> map = new HashMap<>();
		// 1.高亮显示
		map.putAll(searchList(searchMap));

		// 2.根据关键字查询商品分类
		List<String> categoryList = searchCategoryList(searchMap);
		map.put("categoryList", categoryList);

		/**
		 * 当传过来是有分类信息就根据信息查询，没有的话就默认查询第一个分类的信息
		 */
		String category = (String) searchMap.get("category");
		// 3.查询品牌和规格列表
		if (!"".equals(category)) {
			map.putAll(searchBrandAndSpecList(category));
		} else {
			if (categoryList.size() > 0) {
				map.putAll(searchBrandAndSpecList(categoryList.get(0)));
			}
		}
		return map;
	}

	/**
	 * 查询列表
	 * 
	 * @param searchMap
	 * @return
	 */
	private Map<String, Object> searchList(Map searchMap) {
		// 高亮选项初始化
		Map<String, Object> map = new HashMap<>();
		HighlightQuery query = new SimpleHighlightQuery();
		// 设置高亮的域
		HighlightOptions highlightOptions = new HighlightOptions().addField("item_title");
		// 高亮前缀
		highlightOptions.setSimplePrefix("<em style='color:red'>");
		// 高亮后缀
		highlightOptions.setSimplePostfix("</em>");
		// 为查询结果设置高亮
		query.setHighlightOptions(highlightOptions);

		// 1.1添加查询条件
		Criteria criteria = new Criteria("item_keywords").is(searchMap.get("keywords"));
		query.addCriteria(criteria);

		// 1.2按分类筛选
		if (!"".equals(searchMap.get("category"))) { // 当存在分类条件的时候执行
			FilterQuery filterQuery = new SimpleFilterQuery();
			Criteria filterCriteria = new Criteria("item_category").is(searchMap.get("category"));
			filterQuery.addCriteria(filterCriteria);
			query.addFilterQuery(filterQuery);
		}

		// 1.3按品牌筛选
		if (!"".equals(searchMap.get("brand"))) { // 当存在分类条件的时候执行
			FilterQuery filterQuery = new SimpleFilterQuery();
			Criteria filterCriteria = new Criteria("item_brand").is(searchMap.get("brand"));
			filterQuery.addCriteria(filterCriteria);
			query.addFilterQuery(filterQuery);
		}

		// 1.4按规格筛选
		if (searchMap.get("spec") != null) {// 当存在规格条件的时候执行
			Map<String, String> specMap = (Map<String, String>) searchMap.get("spec");
			for (String key : specMap.keySet()) {
				FilterQuery filterQuery = new SimpleFilterQuery();
				Criteria filterCriteria = new Criteria("item_spec_" + key).is(specMap.get(key));
				filterQuery.addCriteria(filterCriteria);
				query.addFilterQuery(filterQuery);
			}
		}

		// 1.5价格筛选
		if (!"".equals(searchMap.get("price"))) {
			String[] price = ((String) searchMap.get("price")).split("-");
			if (!price[0].equals("0")) {// 如果区间起点不等于0
				FilterQuery filterQuery = new SimpleFilterQuery();
				Criteria filterCriteria = new Criteria("item_price").greaterThanEqual(price[0]);
				filterQuery.addCriteria(filterCriteria);
				query.addFilterQuery(filterQuery);
			}
			if (!price[1].equals("*")) {// 如果区间终点不等于*
				FilterQuery filterQuery = new SimpleFilterQuery();
				Criteria filterCriteria = new Criteria("item_price").lessThanEqual(price[1]);
				filterQuery.addCriteria(filterCriteria);
				query.addFilterQuery(filterQuery);
			}
		}

		// 1.6 分页查询
		Integer currPage = (Integer) searchMap.get("currPage"); // 提取页码
		Integer pageSize = (Integer) searchMap.get("pageSize"); // 每页记录数
		if (currPage == null) {
			currPage = 1; // 默认第一页
		}
		if (pageSize == null) {
			pageSize = 15; // 默认15
		}
		query.setOffset((currPage - 1) * pageSize); // 从第几条记录查询
		query.setRows(pageSize); // 每页记录数

		// 1.7 排序
		String sortField = (String) searchMap.get("sortField");// 排序字段
		String sortValue = (String) searchMap.get("sort");// ASC DESC
		if (sortValue != null && !sortValue.equals("")) {
			if (sortValue.equals("ASC")) {
				Sort sort = new Sort(Sort.Direction.ASC, "item_" + sortField);
				query.addSort(sort);
			} else if (sortValue.equals("DESC")) {
				Sort sort = new Sort(Sort.Direction.DESC, "item_" + sortField);
				query.addSort(sort);
			}
		}

		// ******************** 获取高亮结果集 ******************************
		// 高亮页对象
		HighlightPage<TbItem> page = solrTemplate.queryForHighlightPage(query, TbItem.class);
		// 循环高亮入口集合(每天记录的高亮入口)
		List<HighlightEntry<TbItem>> list = page.getHighlighted();
		// 对应的搜索记录
		for (HighlightEntry<TbItem> highlightEntry : list) {
			// 获取高亮列表(高亮域的个数)
			/*
			 * 高亮集合对象（储存的所有的高亮列） List<Highlight> highlights =
			 * highlightEntry.getHighlights(); 高亮对象 for (Highlight highlight : highlights) {
			 * 获取所有值的高亮 List<String> snipplets = highlight.getSnipplets();
			 * System.out.println(snipplets); }
			 */
			// 由于我们要查询的只有一个域和一个值，就可以这样写，直接获取值的高亮
			TbItem item = highlightEntry.getEntity();
			if (highlightEntry.getHighlights().size() > 0
					&& highlightEntry.getHighlights().get(0).getSnipplets().size() > 0) {
				item.setTitle(highlightEntry.getHighlights().get(0).getSnipplets().get(0));// 设置高亮结果
			}
		}
		map.put("rows", page.getContent());
		map.put("totalPages", page.getTotalPages());// 返回总页数
		map.put("totalSize", page.getTotalElements()); // 返回总记录数
		return map;
	}

	/**
	 * 分组查询
	 * 
	 * @param searchMap
	 * @return
	 */
	private List<String> searchCategoryList(Map searchMap) {
		List<String> groupList = new ArrayList<>();
		Query query = new SimpleQuery();
		// 添加查询条件
		Criteria criteria = new Criteria("item_keywords").is(searchMap.get("keywords")); // 相当于sql中的where
		query.addCriteria(criteria);
		// 设置分组选项
		GroupOptions groupOptions = new GroupOptions().addGroupByField("item_category"); // 相当于sql中的group by
		query.setGroupOptions(groupOptions);
		// 得到分组页
		GroupPage<TbItem> page = solrTemplate.queryForGroupPage(query, TbItem.class);
		// 根据列得到分组结果集
		GroupResult<TbItem> groupResult = page.getGroupResult("item_category");
		// 得到分组结果入口页
		Page<GroupEntry<TbItem>> groupEntries = groupResult.getGroupEntries();
		// 得到分组入口集合
		List<GroupEntry<TbItem>> list = groupEntries.getContent();
		for (GroupEntry<TbItem> groupEntry : list) {
			// 将分组结果的名称封装到返回值中
			groupList.add(groupEntry.getGroupValue());
		}
		return groupList;
	}

	@Autowired
	private RedisTemplate redisTemplate;

	/**
	 * 查询品牌和规格列表
	 * 
	 * @param category
	 *            商品分类名
	 * @return
	 */
	@SuppressWarnings("all")
	private Map searchBrandAndSpecList(String category) {
		Map map = new HashMap();
		Long typeId = (Long) redisTemplate.boundHashOps("itemCat").get(category);
		if (typeId != null) {
			// 根据模板ID查询品牌列表
			List<Map> brandList = (List<Map>) redisTemplate.boundHashOps("brandList").get(typeId);
			// 返回值添加品牌列表
			map.put("brandList", brandList);
			// 根据模板ID查询规格列表
			List<Map> specList = (List<Map>) redisTemplate.boundHashOps("specList").get(typeId);
			// 返回值添加规格列表
			map.put("specList", specList);
		}
		return map;
	}

	@Override
	public void importList(List list) {
		solrTemplate.saveBeans(list);
		solrTemplate.commit();
	}

	@Override
	public void deleteByGoodsIds(List goodsIdList) {
		SolrDataQuery query = new SimpleQuery();
		Criteria criteria = new Criteria("item_goodsid").in(goodsIdList);
		query.addCriteria(criteria);
		solrTemplate.delete(query);
		solrTemplate.commit();
	}
}
