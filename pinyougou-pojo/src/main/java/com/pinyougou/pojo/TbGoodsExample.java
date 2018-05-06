package com.pinyougou.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class TbGoodsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbGoodsExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andSellerIdIsNull() {
            addCriterion("seller_id is null");
            return (Criteria) this;
        }

        public Criteria andSellerIdIsNotNull() {
            addCriterion("seller_id is not null");
            return (Criteria) this;
        }

        public Criteria andSellerIdEqualTo(String value) {
            addCriterion("seller_id =", value, "sellerId");
            return (Criteria) this;
        }

        public Criteria andSellerIdNotEqualTo(String value) {
            addCriterion("seller_id <>", value, "sellerId");
            return (Criteria) this;
        }

        public Criteria andSellerIdGreaterThan(String value) {
            addCriterion("seller_id >", value, "sellerId");
            return (Criteria) this;
        }

        public Criteria andSellerIdGreaterThanOrEqualTo(String value) {
            addCriterion("seller_id >=", value, "sellerId");
            return (Criteria) this;
        }

        public Criteria andSellerIdLessThan(String value) {
            addCriterion("seller_id <", value, "sellerId");
            return (Criteria) this;
        }

        public Criteria andSellerIdLessThanOrEqualTo(String value) {
            addCriterion("seller_id <=", value, "sellerId");
            return (Criteria) this;
        }

        public Criteria andSellerIdLike(String value) {
            addCriterion("seller_id like", value, "sellerId");
            return (Criteria) this;
        }

        public Criteria andSellerIdNotLike(String value) {
            addCriterion("seller_id not like", value, "sellerId");
            return (Criteria) this;
        }

        public Criteria andSellerIdIn(List<String> values) {
            addCriterion("seller_id in", values, "sellerId");
            return (Criteria) this;
        }

        public Criteria andSellerIdNotIn(List<String> values) {
            addCriterion("seller_id not in", values, "sellerId");
            return (Criteria) this;
        }

        public Criteria andSellerIdBetween(String value1, String value2) {
            addCriterion("seller_id between", value1, value2, "sellerId");
            return (Criteria) this;
        }

        public Criteria andSellerIdNotBetween(String value1, String value2) {
            addCriterion("seller_id not between", value1, value2, "sellerId");
            return (Criteria) this;
        }

        public Criteria andGoodsNameIsNull() {
            addCriterion("goods_name is null");
            return (Criteria) this;
        }

        public Criteria andGoodsNameIsNotNull() {
            addCriterion("goods_name is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsNameEqualTo(String value) {
            addCriterion("goods_name =", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameNotEqualTo(String value) {
            addCriterion("goods_name <>", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameGreaterThan(String value) {
            addCriterion("goods_name >", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameGreaterThanOrEqualTo(String value) {
            addCriterion("goods_name >=", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameLessThan(String value) {
            addCriterion("goods_name <", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameLessThanOrEqualTo(String value) {
            addCriterion("goods_name <=", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameLike(String value) {
            addCriterion("goods_name like", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameNotLike(String value) {
            addCriterion("goods_name not like", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameIn(List<String> values) {
            addCriterion("goods_name in", values, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameNotIn(List<String> values) {
            addCriterion("goods_name not in", values, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameBetween(String value1, String value2) {
            addCriterion("goods_name between", value1, value2, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameNotBetween(String value1, String value2) {
            addCriterion("goods_name not between", value1, value2, "goodsName");
            return (Criteria) this;
        }

        public Criteria andDefaultItemIdIsNull() {
            addCriterion("default_item_id is null");
            return (Criteria) this;
        }

        public Criteria andDefaultItemIdIsNotNull() {
            addCriterion("default_item_id is not null");
            return (Criteria) this;
        }

        public Criteria andDefaultItemIdEqualTo(Long value) {
            addCriterion("default_item_id =", value, "defaultItemId");
            return (Criteria) this;
        }

        public Criteria andDefaultItemIdNotEqualTo(Long value) {
            addCriterion("default_item_id <>", value, "defaultItemId");
            return (Criteria) this;
        }

        public Criteria andDefaultItemIdGreaterThan(Long value) {
            addCriterion("default_item_id >", value, "defaultItemId");
            return (Criteria) this;
        }

        public Criteria andDefaultItemIdGreaterThanOrEqualTo(Long value) {
            addCriterion("default_item_id >=", value, "defaultItemId");
            return (Criteria) this;
        }

        public Criteria andDefaultItemIdLessThan(Long value) {
            addCriterion("default_item_id <", value, "defaultItemId");
            return (Criteria) this;
        }

        public Criteria andDefaultItemIdLessThanOrEqualTo(Long value) {
            addCriterion("default_item_id <=", value, "defaultItemId");
            return (Criteria) this;
        }

        public Criteria andDefaultItemIdIn(List<Long> values) {
            addCriterion("default_item_id in", values, "defaultItemId");
            return (Criteria) this;
        }

        public Criteria andDefaultItemIdNotIn(List<Long> values) {
            addCriterion("default_item_id not in", values, "defaultItemId");
            return (Criteria) this;
        }

        public Criteria andDefaultItemIdBetween(Long value1, Long value2) {
            addCriterion("default_item_id between", value1, value2, "defaultItemId");
            return (Criteria) this;
        }

        public Criteria andDefaultItemIdNotBetween(Long value1, Long value2) {
            addCriterion("default_item_id not between", value1, value2, "defaultItemId");
            return (Criteria) this;
        }

        public Criteria andAuditStatusIsNull() {
            addCriterion("audit_status is null");
            return (Criteria) this;
        }

        public Criteria andAuditStatusIsNotNull() {
            addCriterion("audit_status is not null");
            return (Criteria) this;
        }

        public Criteria andAuditStatusEqualTo(String value) {
            addCriterion("audit_status =", value, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusNotEqualTo(String value) {
            addCriterion("audit_status <>", value, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusGreaterThan(String value) {
            addCriterion("audit_status >", value, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusGreaterThanOrEqualTo(String value) {
            addCriterion("audit_status >=", value, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusLessThan(String value) {
            addCriterion("audit_status <", value, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusLessThanOrEqualTo(String value) {
            addCriterion("audit_status <=", value, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusLike(String value) {
            addCriterion("audit_status like", value, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusNotLike(String value) {
            addCriterion("audit_status not like", value, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusIn(List<String> values) {
            addCriterion("audit_status in", values, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusNotIn(List<String> values) {
            addCriterion("audit_status not in", values, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusBetween(String value1, String value2) {
            addCriterion("audit_status between", value1, value2, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusNotBetween(String value1, String value2) {
            addCriterion("audit_status not between", value1, value2, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andIsMarketableIsNull() {
            addCriterion("is_marketable is null");
            return (Criteria) this;
        }

        public Criteria andIsMarketableIsNotNull() {
            addCriterion("is_marketable is not null");
            return (Criteria) this;
        }

        public Criteria andIsMarketableEqualTo(String value) {
            addCriterion("is_marketable =", value, "isMarketable");
            return (Criteria) this;
        }

        public Criteria andIsMarketableNotEqualTo(String value) {
            addCriterion("is_marketable <>", value, "isMarketable");
            return (Criteria) this;
        }

        public Criteria andIsMarketableGreaterThan(String value) {
            addCriterion("is_marketable >", value, "isMarketable");
            return (Criteria) this;
        }

        public Criteria andIsMarketableGreaterThanOrEqualTo(String value) {
            addCriterion("is_marketable >=", value, "isMarketable");
            return (Criteria) this;
        }

        public Criteria andIsMarketableLessThan(String value) {
            addCriterion("is_marketable <", value, "isMarketable");
            return (Criteria) this;
        }

        public Criteria andIsMarketableLessThanOrEqualTo(String value) {
            addCriterion("is_marketable <=", value, "isMarketable");
            return (Criteria) this;
        }

        public Criteria andIsMarketableLike(String value) {
            addCriterion("is_marketable like", value, "isMarketable");
            return (Criteria) this;
        }

        public Criteria andIsMarketableNotLike(String value) {
            addCriterion("is_marketable not like", value, "isMarketable");
            return (Criteria) this;
        }

        public Criteria andIsMarketableIn(List<String> values) {
            addCriterion("is_marketable in", values, "isMarketable");
            return (Criteria) this;
        }

        public Criteria andIsMarketableNotIn(List<String> values) {
            addCriterion("is_marketable not in", values, "isMarketable");
            return (Criteria) this;
        }

        public Criteria andIsMarketableBetween(String value1, String value2) {
            addCriterion("is_marketable between", value1, value2, "isMarketable");
            return (Criteria) this;
        }

        public Criteria andIsMarketableNotBetween(String value1, String value2) {
            addCriterion("is_marketable not between", value1, value2, "isMarketable");
            return (Criteria) this;
        }

        public Criteria andBrandIdIsNull() {
            addCriterion("brand_id is null");
            return (Criteria) this;
        }

        public Criteria andBrandIdIsNotNull() {
            addCriterion("brand_id is not null");
            return (Criteria) this;
        }

        public Criteria andBrandIdEqualTo(Long value) {
            addCriterion("brand_id =", value, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdNotEqualTo(Long value) {
            addCriterion("brand_id <>", value, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdGreaterThan(Long value) {
            addCriterion("brand_id >", value, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdGreaterThanOrEqualTo(Long value) {
            addCriterion("brand_id >=", value, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdLessThan(Long value) {
            addCriterion("brand_id <", value, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdLessThanOrEqualTo(Long value) {
            addCriterion("brand_id <=", value, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdIn(List<Long> values) {
            addCriterion("brand_id in", values, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdNotIn(List<Long> values) {
            addCriterion("brand_id not in", values, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdBetween(Long value1, Long value2) {
            addCriterion("brand_id between", value1, value2, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdNotBetween(Long value1, Long value2) {
            addCriterion("brand_id not between", value1, value2, "brandId");
            return (Criteria) this;
        }

        public Criteria andCaptionIsNull() {
            addCriterion("caption is null");
            return (Criteria) this;
        }

        public Criteria andCaptionIsNotNull() {
            addCriterion("caption is not null");
            return (Criteria) this;
        }

        public Criteria andCaptionEqualTo(String value) {
            addCriterion("caption =", value, "caption");
            return (Criteria) this;
        }

        public Criteria andCaptionNotEqualTo(String value) {
            addCriterion("caption <>", value, "caption");
            return (Criteria) this;
        }

        public Criteria andCaptionGreaterThan(String value) {
            addCriterion("caption >", value, "caption");
            return (Criteria) this;
        }

        public Criteria andCaptionGreaterThanOrEqualTo(String value) {
            addCriterion("caption >=", value, "caption");
            return (Criteria) this;
        }

        public Criteria andCaptionLessThan(String value) {
            addCriterion("caption <", value, "caption");
            return (Criteria) this;
        }

        public Criteria andCaptionLessThanOrEqualTo(String value) {
            addCriterion("caption <=", value, "caption");
            return (Criteria) this;
        }

        public Criteria andCaptionLike(String value) {
            addCriterion("caption like", value, "caption");
            return (Criteria) this;
        }

        public Criteria andCaptionNotLike(String value) {
            addCriterion("caption not like", value, "caption");
            return (Criteria) this;
        }

        public Criteria andCaptionIn(List<String> values) {
            addCriterion("caption in", values, "caption");
            return (Criteria) this;
        }

        public Criteria andCaptionNotIn(List<String> values) {
            addCriterion("caption not in", values, "caption");
            return (Criteria) this;
        }

        public Criteria andCaptionBetween(String value1, String value2) {
            addCriterion("caption between", value1, value2, "caption");
            return (Criteria) this;
        }

        public Criteria andCaptionNotBetween(String value1, String value2) {
            addCriterion("caption not between", value1, value2, "caption");
            return (Criteria) this;
        }

        public Criteria andCategory1IdIsNull() {
            addCriterion("category1_id is null");
            return (Criteria) this;
        }

        public Criteria andCategory1IdIsNotNull() {
            addCriterion("category1_id is not null");
            return (Criteria) this;
        }

        public Criteria andCategory1IdEqualTo(Long value) {
            addCriterion("category1_id =", value, "category1Id");
            return (Criteria) this;
        }

        public Criteria andCategory1IdNotEqualTo(Long value) {
            addCriterion("category1_id <>", value, "category1Id");
            return (Criteria) this;
        }

        public Criteria andCategory1IdGreaterThan(Long value) {
            addCriterion("category1_id >", value, "category1Id");
            return (Criteria) this;
        }

        public Criteria andCategory1IdGreaterThanOrEqualTo(Long value) {
            addCriterion("category1_id >=", value, "category1Id");
            return (Criteria) this;
        }

        public Criteria andCategory1IdLessThan(Long value) {
            addCriterion("category1_id <", value, "category1Id");
            return (Criteria) this;
        }

        public Criteria andCategory1IdLessThanOrEqualTo(Long value) {
            addCriterion("category1_id <=", value, "category1Id");
            return (Criteria) this;
        }

        public Criteria andCategory1IdIn(List<Long> values) {
            addCriterion("category1_id in", values, "category1Id");
            return (Criteria) this;
        }

        public Criteria andCategory1IdNotIn(List<Long> values) {
            addCriterion("category1_id not in", values, "category1Id");
            return (Criteria) this;
        }

        public Criteria andCategory1IdBetween(Long value1, Long value2) {
            addCriterion("category1_id between", value1, value2, "category1Id");
            return (Criteria) this;
        }

        public Criteria andCategory1IdNotBetween(Long value1, Long value2) {
            addCriterion("category1_id not between", value1, value2, "category1Id");
            return (Criteria) this;
        }

        public Criteria andCategory2IdIsNull() {
            addCriterion("category2_id is null");
            return (Criteria) this;
        }

        public Criteria andCategory2IdIsNotNull() {
            addCriterion("category2_id is not null");
            return (Criteria) this;
        }

        public Criteria andCategory2IdEqualTo(Long value) {
            addCriterion("category2_id =", value, "category2Id");
            return (Criteria) this;
        }

        public Criteria andCategory2IdNotEqualTo(Long value) {
            addCriterion("category2_id <>", value, "category2Id");
            return (Criteria) this;
        }

        public Criteria andCategory2IdGreaterThan(Long value) {
            addCriterion("category2_id >", value, "category2Id");
            return (Criteria) this;
        }

        public Criteria andCategory2IdGreaterThanOrEqualTo(Long value) {
            addCriterion("category2_id >=", value, "category2Id");
            return (Criteria) this;
        }

        public Criteria andCategory2IdLessThan(Long value) {
            addCriterion("category2_id <", value, "category2Id");
            return (Criteria) this;
        }

        public Criteria andCategory2IdLessThanOrEqualTo(Long value) {
            addCriterion("category2_id <=", value, "category2Id");
            return (Criteria) this;
        }

        public Criteria andCategory2IdIn(List<Long> values) {
            addCriterion("category2_id in", values, "category2Id");
            return (Criteria) this;
        }

        public Criteria andCategory2IdNotIn(List<Long> values) {
            addCriterion("category2_id not in", values, "category2Id");
            return (Criteria) this;
        }

        public Criteria andCategory2IdBetween(Long value1, Long value2) {
            addCriterion("category2_id between", value1, value2, "category2Id");
            return (Criteria) this;
        }

        public Criteria andCategory2IdNotBetween(Long value1, Long value2) {
            addCriterion("category2_id not between", value1, value2, "category2Id");
            return (Criteria) this;
        }

        public Criteria andCategory3IdIsNull() {
            addCriterion("category3_id is null");
            return (Criteria) this;
        }

        public Criteria andCategory3IdIsNotNull() {
            addCriterion("category3_id is not null");
            return (Criteria) this;
        }

        public Criteria andCategory3IdEqualTo(Long value) {
            addCriterion("category3_id =", value, "category3Id");
            return (Criteria) this;
        }

        public Criteria andCategory3IdNotEqualTo(Long value) {
            addCriterion("category3_id <>", value, "category3Id");
            return (Criteria) this;
        }

        public Criteria andCategory3IdGreaterThan(Long value) {
            addCriterion("category3_id >", value, "category3Id");
            return (Criteria) this;
        }

        public Criteria andCategory3IdGreaterThanOrEqualTo(Long value) {
            addCriterion("category3_id >=", value, "category3Id");
            return (Criteria) this;
        }

        public Criteria andCategory3IdLessThan(Long value) {
            addCriterion("category3_id <", value, "category3Id");
            return (Criteria) this;
        }

        public Criteria andCategory3IdLessThanOrEqualTo(Long value) {
            addCriterion("category3_id <=", value, "category3Id");
            return (Criteria) this;
        }

        public Criteria andCategory3IdIn(List<Long> values) {
            addCriterion("category3_id in", values, "category3Id");
            return (Criteria) this;
        }

        public Criteria andCategory3IdNotIn(List<Long> values) {
            addCriterion("category3_id not in", values, "category3Id");
            return (Criteria) this;
        }

        public Criteria andCategory3IdBetween(Long value1, Long value2) {
            addCriterion("category3_id between", value1, value2, "category3Id");
            return (Criteria) this;
        }

        public Criteria andCategory3IdNotBetween(Long value1, Long value2) {
            addCriterion("category3_id not between", value1, value2, "category3Id");
            return (Criteria) this;
        }

        public Criteria andSmallPicIsNull() {
            addCriterion("small_pic is null");
            return (Criteria) this;
        }

        public Criteria andSmallPicIsNotNull() {
            addCriterion("small_pic is not null");
            return (Criteria) this;
        }

        public Criteria andSmallPicEqualTo(String value) {
            addCriterion("small_pic =", value, "smallPic");
            return (Criteria) this;
        }

        public Criteria andSmallPicNotEqualTo(String value) {
            addCriterion("small_pic <>", value, "smallPic");
            return (Criteria) this;
        }

        public Criteria andSmallPicGreaterThan(String value) {
            addCriterion("small_pic >", value, "smallPic");
            return (Criteria) this;
        }

        public Criteria andSmallPicGreaterThanOrEqualTo(String value) {
            addCriterion("small_pic >=", value, "smallPic");
            return (Criteria) this;
        }

        public Criteria andSmallPicLessThan(String value) {
            addCriterion("small_pic <", value, "smallPic");
            return (Criteria) this;
        }

        public Criteria andSmallPicLessThanOrEqualTo(String value) {
            addCriterion("small_pic <=", value, "smallPic");
            return (Criteria) this;
        }

        public Criteria andSmallPicLike(String value) {
            addCriterion("small_pic like", value, "smallPic");
            return (Criteria) this;
        }

        public Criteria andSmallPicNotLike(String value) {
            addCriterion("small_pic not like", value, "smallPic");
            return (Criteria) this;
        }

        public Criteria andSmallPicIn(List<String> values) {
            addCriterion("small_pic in", values, "smallPic");
            return (Criteria) this;
        }

        public Criteria andSmallPicNotIn(List<String> values) {
            addCriterion("small_pic not in", values, "smallPic");
            return (Criteria) this;
        }

        public Criteria andSmallPicBetween(String value1, String value2) {
            addCriterion("small_pic between", value1, value2, "smallPic");
            return (Criteria) this;
        }

        public Criteria andSmallPicNotBetween(String value1, String value2) {
            addCriterion("small_pic not between", value1, value2, "smallPic");
            return (Criteria) this;
        }

        public Criteria andPriceIsNull() {
            addCriterion("price is null");
            return (Criteria) this;
        }

        public Criteria andPriceIsNotNull() {
            addCriterion("price is not null");
            return (Criteria) this;
        }

        public Criteria andPriceEqualTo(BigDecimal value) {
            addCriterion("price =", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotEqualTo(BigDecimal value) {
            addCriterion("price <>", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThan(BigDecimal value) {
            addCriterion("price >", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("price >=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThan(BigDecimal value) {
            addCriterion("price <", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("price <=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceIn(List<BigDecimal> values) {
            addCriterion("price in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotIn(List<BigDecimal> values) {
            addCriterion("price not in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price not between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andTypeTemplateIdIsNull() {
            addCriterion("type_template_id is null");
            return (Criteria) this;
        }

        public Criteria andTypeTemplateIdIsNotNull() {
            addCriterion("type_template_id is not null");
            return (Criteria) this;
        }

        public Criteria andTypeTemplateIdEqualTo(Long value) {
            addCriterion("type_template_id =", value, "typeTemplateId");
            return (Criteria) this;
        }

        public Criteria andTypeTemplateIdNotEqualTo(Long value) {
            addCriterion("type_template_id <>", value, "typeTemplateId");
            return (Criteria) this;
        }

        public Criteria andTypeTemplateIdGreaterThan(Long value) {
            addCriterion("type_template_id >", value, "typeTemplateId");
            return (Criteria) this;
        }

        public Criteria andTypeTemplateIdGreaterThanOrEqualTo(Long value) {
            addCriterion("type_template_id >=", value, "typeTemplateId");
            return (Criteria) this;
        }

        public Criteria andTypeTemplateIdLessThan(Long value) {
            addCriterion("type_template_id <", value, "typeTemplateId");
            return (Criteria) this;
        }

        public Criteria andTypeTemplateIdLessThanOrEqualTo(Long value) {
            addCriterion("type_template_id <=", value, "typeTemplateId");
            return (Criteria) this;
        }

        public Criteria andTypeTemplateIdIn(List<Long> values) {
            addCriterion("type_template_id in", values, "typeTemplateId");
            return (Criteria) this;
        }

        public Criteria andTypeTemplateIdNotIn(List<Long> values) {
            addCriterion("type_template_id not in", values, "typeTemplateId");
            return (Criteria) this;
        }

        public Criteria andTypeTemplateIdBetween(Long value1, Long value2) {
            addCriterion("type_template_id between", value1, value2, "typeTemplateId");
            return (Criteria) this;
        }

        public Criteria andTypeTemplateIdNotBetween(Long value1, Long value2) {
            addCriterion("type_template_id not between", value1, value2, "typeTemplateId");
            return (Criteria) this;
        }

        public Criteria andIsEnableSpecIsNull() {
            addCriterion("is_enable_spec is null");
            return (Criteria) this;
        }

        public Criteria andIsEnableSpecIsNotNull() {
            addCriterion("is_enable_spec is not null");
            return (Criteria) this;
        }

        public Criteria andIsEnableSpecEqualTo(String value) {
            addCriterion("is_enable_spec =", value, "isEnableSpec");
            return (Criteria) this;
        }

        public Criteria andIsEnableSpecNotEqualTo(String value) {
            addCriterion("is_enable_spec <>", value, "isEnableSpec");
            return (Criteria) this;
        }

        public Criteria andIsEnableSpecGreaterThan(String value) {
            addCriterion("is_enable_spec >", value, "isEnableSpec");
            return (Criteria) this;
        }

        public Criteria andIsEnableSpecGreaterThanOrEqualTo(String value) {
            addCriterion("is_enable_spec >=", value, "isEnableSpec");
            return (Criteria) this;
        }

        public Criteria andIsEnableSpecLessThan(String value) {
            addCriterion("is_enable_spec <", value, "isEnableSpec");
            return (Criteria) this;
        }

        public Criteria andIsEnableSpecLessThanOrEqualTo(String value) {
            addCriterion("is_enable_spec <=", value, "isEnableSpec");
            return (Criteria) this;
        }

        public Criteria andIsEnableSpecLike(String value) {
            addCriterion("is_enable_spec like", value, "isEnableSpec");
            return (Criteria) this;
        }

        public Criteria andIsEnableSpecNotLike(String value) {
            addCriterion("is_enable_spec not like", value, "isEnableSpec");
            return (Criteria) this;
        }

        public Criteria andIsEnableSpecIn(List<String> values) {
            addCriterion("is_enable_spec in", values, "isEnableSpec");
            return (Criteria) this;
        }

        public Criteria andIsEnableSpecNotIn(List<String> values) {
            addCriterion("is_enable_spec not in", values, "isEnableSpec");
            return (Criteria) this;
        }

        public Criteria andIsEnableSpecBetween(String value1, String value2) {
            addCriterion("is_enable_spec between", value1, value2, "isEnableSpec");
            return (Criteria) this;
        }

        public Criteria andIsEnableSpecNotBetween(String value1, String value2) {
            addCriterion("is_enable_spec not between", value1, value2, "isEnableSpec");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIsNull() {
            addCriterion("is_delete is null");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIsNotNull() {
            addCriterion("is_delete is not null");
            return (Criteria) this;
        }

        public Criteria andIsDeleteEqualTo(String value) {
            addCriterion("is_delete =", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotEqualTo(String value) {
            addCriterion("is_delete <>", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteGreaterThan(String value) {
            addCriterion("is_delete >", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteGreaterThanOrEqualTo(String value) {
            addCriterion("is_delete >=", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteLessThan(String value) {
            addCriterion("is_delete <", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteLessThanOrEqualTo(String value) {
            addCriterion("is_delete <=", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteLike(String value) {
            addCriterion("is_delete like", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotLike(String value) {
            addCriterion("is_delete not like", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIn(List<String> values) {
            addCriterion("is_delete in", values, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotIn(List<String> values) {
            addCriterion("is_delete not in", values, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteBetween(String value1, String value2) {
            addCriterion("is_delete between", value1, value2, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotBetween(String value1, String value2) {
            addCriterion("is_delete not between", value1, value2, "isDelete");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}