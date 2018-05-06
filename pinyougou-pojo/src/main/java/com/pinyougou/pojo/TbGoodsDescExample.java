package com.pinyougou.pojo;

import java.util.ArrayList;
import java.util.List;

public class TbGoodsDescExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbGoodsDescExample() {
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

        public Criteria andGoodsIdIsNull() {
            addCriterion("goods_id is null");
            return (Criteria) this;
        }

        public Criteria andGoodsIdIsNotNull() {
            addCriterion("goods_id is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsIdEqualTo(Long value) {
            addCriterion("goods_id =", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdNotEqualTo(Long value) {
            addCriterion("goods_id <>", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdGreaterThan(Long value) {
            addCriterion("goods_id >", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdGreaterThanOrEqualTo(Long value) {
            addCriterion("goods_id >=", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdLessThan(Long value) {
            addCriterion("goods_id <", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdLessThanOrEqualTo(Long value) {
            addCriterion("goods_id <=", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdIn(List<Long> values) {
            addCriterion("goods_id in", values, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdNotIn(List<Long> values) {
            addCriterion("goods_id not in", values, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdBetween(Long value1, Long value2) {
            addCriterion("goods_id between", value1, value2, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdNotBetween(Long value1, Long value2) {
            addCriterion("goods_id not between", value1, value2, "goodsId");
            return (Criteria) this;
        }

        public Criteria andIntroductionIsNull() {
            addCriterion("introduction is null");
            return (Criteria) this;
        }

        public Criteria andIntroductionIsNotNull() {
            addCriterion("introduction is not null");
            return (Criteria) this;
        }

        public Criteria andIntroductionEqualTo(String value) {
            addCriterion("introduction =", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionNotEqualTo(String value) {
            addCriterion("introduction <>", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionGreaterThan(String value) {
            addCriterion("introduction >", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionGreaterThanOrEqualTo(String value) {
            addCriterion("introduction >=", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionLessThan(String value) {
            addCriterion("introduction <", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionLessThanOrEqualTo(String value) {
            addCriterion("introduction <=", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionLike(String value) {
            addCriterion("introduction like", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionNotLike(String value) {
            addCriterion("introduction not like", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionIn(List<String> values) {
            addCriterion("introduction in", values, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionNotIn(List<String> values) {
            addCriterion("introduction not in", values, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionBetween(String value1, String value2) {
            addCriterion("introduction between", value1, value2, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionNotBetween(String value1, String value2) {
            addCriterion("introduction not between", value1, value2, "introduction");
            return (Criteria) this;
        }

        public Criteria andSpecificationItemsIsNull() {
            addCriterion("specification_items is null");
            return (Criteria) this;
        }

        public Criteria andSpecificationItemsIsNotNull() {
            addCriterion("specification_items is not null");
            return (Criteria) this;
        }

        public Criteria andSpecificationItemsEqualTo(String value) {
            addCriterion("specification_items =", value, "specificationItems");
            return (Criteria) this;
        }

        public Criteria andSpecificationItemsNotEqualTo(String value) {
            addCriterion("specification_items <>", value, "specificationItems");
            return (Criteria) this;
        }

        public Criteria andSpecificationItemsGreaterThan(String value) {
            addCriterion("specification_items >", value, "specificationItems");
            return (Criteria) this;
        }

        public Criteria andSpecificationItemsGreaterThanOrEqualTo(String value) {
            addCriterion("specification_items >=", value, "specificationItems");
            return (Criteria) this;
        }

        public Criteria andSpecificationItemsLessThan(String value) {
            addCriterion("specification_items <", value, "specificationItems");
            return (Criteria) this;
        }

        public Criteria andSpecificationItemsLessThanOrEqualTo(String value) {
            addCriterion("specification_items <=", value, "specificationItems");
            return (Criteria) this;
        }

        public Criteria andSpecificationItemsLike(String value) {
            addCriterion("specification_items like", value, "specificationItems");
            return (Criteria) this;
        }

        public Criteria andSpecificationItemsNotLike(String value) {
            addCriterion("specification_items not like", value, "specificationItems");
            return (Criteria) this;
        }

        public Criteria andSpecificationItemsIn(List<String> values) {
            addCriterion("specification_items in", values, "specificationItems");
            return (Criteria) this;
        }

        public Criteria andSpecificationItemsNotIn(List<String> values) {
            addCriterion("specification_items not in", values, "specificationItems");
            return (Criteria) this;
        }

        public Criteria andSpecificationItemsBetween(String value1, String value2) {
            addCriterion("specification_items between", value1, value2, "specificationItems");
            return (Criteria) this;
        }

        public Criteria andSpecificationItemsNotBetween(String value1, String value2) {
            addCriterion("specification_items not between", value1, value2, "specificationItems");
            return (Criteria) this;
        }

        public Criteria andCustomAttributeItemsIsNull() {
            addCriterion("custom_attribute_items is null");
            return (Criteria) this;
        }

        public Criteria andCustomAttributeItemsIsNotNull() {
            addCriterion("custom_attribute_items is not null");
            return (Criteria) this;
        }

        public Criteria andCustomAttributeItemsEqualTo(String value) {
            addCriterion("custom_attribute_items =", value, "customAttributeItems");
            return (Criteria) this;
        }

        public Criteria andCustomAttributeItemsNotEqualTo(String value) {
            addCriterion("custom_attribute_items <>", value, "customAttributeItems");
            return (Criteria) this;
        }

        public Criteria andCustomAttributeItemsGreaterThan(String value) {
            addCriterion("custom_attribute_items >", value, "customAttributeItems");
            return (Criteria) this;
        }

        public Criteria andCustomAttributeItemsGreaterThanOrEqualTo(String value) {
            addCriterion("custom_attribute_items >=", value, "customAttributeItems");
            return (Criteria) this;
        }

        public Criteria andCustomAttributeItemsLessThan(String value) {
            addCriterion("custom_attribute_items <", value, "customAttributeItems");
            return (Criteria) this;
        }

        public Criteria andCustomAttributeItemsLessThanOrEqualTo(String value) {
            addCriterion("custom_attribute_items <=", value, "customAttributeItems");
            return (Criteria) this;
        }

        public Criteria andCustomAttributeItemsLike(String value) {
            addCriterion("custom_attribute_items like", value, "customAttributeItems");
            return (Criteria) this;
        }

        public Criteria andCustomAttributeItemsNotLike(String value) {
            addCriterion("custom_attribute_items not like", value, "customAttributeItems");
            return (Criteria) this;
        }

        public Criteria andCustomAttributeItemsIn(List<String> values) {
            addCriterion("custom_attribute_items in", values, "customAttributeItems");
            return (Criteria) this;
        }

        public Criteria andCustomAttributeItemsNotIn(List<String> values) {
            addCriterion("custom_attribute_items not in", values, "customAttributeItems");
            return (Criteria) this;
        }

        public Criteria andCustomAttributeItemsBetween(String value1, String value2) {
            addCriterion("custom_attribute_items between", value1, value2, "customAttributeItems");
            return (Criteria) this;
        }

        public Criteria andCustomAttributeItemsNotBetween(String value1, String value2) {
            addCriterion("custom_attribute_items not between", value1, value2, "customAttributeItems");
            return (Criteria) this;
        }

        public Criteria andItemImagesIsNull() {
            addCriterion("item_images is null");
            return (Criteria) this;
        }

        public Criteria andItemImagesIsNotNull() {
            addCriterion("item_images is not null");
            return (Criteria) this;
        }

        public Criteria andItemImagesEqualTo(String value) {
            addCriterion("item_images =", value, "itemImages");
            return (Criteria) this;
        }

        public Criteria andItemImagesNotEqualTo(String value) {
            addCriterion("item_images <>", value, "itemImages");
            return (Criteria) this;
        }

        public Criteria andItemImagesGreaterThan(String value) {
            addCriterion("item_images >", value, "itemImages");
            return (Criteria) this;
        }

        public Criteria andItemImagesGreaterThanOrEqualTo(String value) {
            addCriterion("item_images >=", value, "itemImages");
            return (Criteria) this;
        }

        public Criteria andItemImagesLessThan(String value) {
            addCriterion("item_images <", value, "itemImages");
            return (Criteria) this;
        }

        public Criteria andItemImagesLessThanOrEqualTo(String value) {
            addCriterion("item_images <=", value, "itemImages");
            return (Criteria) this;
        }

        public Criteria andItemImagesLike(String value) {
            addCriterion("item_images like", value, "itemImages");
            return (Criteria) this;
        }

        public Criteria andItemImagesNotLike(String value) {
            addCriterion("item_images not like", value, "itemImages");
            return (Criteria) this;
        }

        public Criteria andItemImagesIn(List<String> values) {
            addCriterion("item_images in", values, "itemImages");
            return (Criteria) this;
        }

        public Criteria andItemImagesNotIn(List<String> values) {
            addCriterion("item_images not in", values, "itemImages");
            return (Criteria) this;
        }

        public Criteria andItemImagesBetween(String value1, String value2) {
            addCriterion("item_images between", value1, value2, "itemImages");
            return (Criteria) this;
        }

        public Criteria andItemImagesNotBetween(String value1, String value2) {
            addCriterion("item_images not between", value1, value2, "itemImages");
            return (Criteria) this;
        }

        public Criteria andPackageListIsNull() {
            addCriterion("package_list is null");
            return (Criteria) this;
        }

        public Criteria andPackageListIsNotNull() {
            addCriterion("package_list is not null");
            return (Criteria) this;
        }

        public Criteria andPackageListEqualTo(String value) {
            addCriterion("package_list =", value, "packageList");
            return (Criteria) this;
        }

        public Criteria andPackageListNotEqualTo(String value) {
            addCriterion("package_list <>", value, "packageList");
            return (Criteria) this;
        }

        public Criteria andPackageListGreaterThan(String value) {
            addCriterion("package_list >", value, "packageList");
            return (Criteria) this;
        }

        public Criteria andPackageListGreaterThanOrEqualTo(String value) {
            addCriterion("package_list >=", value, "packageList");
            return (Criteria) this;
        }

        public Criteria andPackageListLessThan(String value) {
            addCriterion("package_list <", value, "packageList");
            return (Criteria) this;
        }

        public Criteria andPackageListLessThanOrEqualTo(String value) {
            addCriterion("package_list <=", value, "packageList");
            return (Criteria) this;
        }

        public Criteria andPackageListLike(String value) {
            addCriterion("package_list like", value, "packageList");
            return (Criteria) this;
        }

        public Criteria andPackageListNotLike(String value) {
            addCriterion("package_list not like", value, "packageList");
            return (Criteria) this;
        }

        public Criteria andPackageListIn(List<String> values) {
            addCriterion("package_list in", values, "packageList");
            return (Criteria) this;
        }

        public Criteria andPackageListNotIn(List<String> values) {
            addCriterion("package_list not in", values, "packageList");
            return (Criteria) this;
        }

        public Criteria andPackageListBetween(String value1, String value2) {
            addCriterion("package_list between", value1, value2, "packageList");
            return (Criteria) this;
        }

        public Criteria andPackageListNotBetween(String value1, String value2) {
            addCriterion("package_list not between", value1, value2, "packageList");
            return (Criteria) this;
        }

        public Criteria andSaleServiceIsNull() {
            addCriterion("sale_service is null");
            return (Criteria) this;
        }

        public Criteria andSaleServiceIsNotNull() {
            addCriterion("sale_service is not null");
            return (Criteria) this;
        }

        public Criteria andSaleServiceEqualTo(String value) {
            addCriterion("sale_service =", value, "saleService");
            return (Criteria) this;
        }

        public Criteria andSaleServiceNotEqualTo(String value) {
            addCriterion("sale_service <>", value, "saleService");
            return (Criteria) this;
        }

        public Criteria andSaleServiceGreaterThan(String value) {
            addCriterion("sale_service >", value, "saleService");
            return (Criteria) this;
        }

        public Criteria andSaleServiceGreaterThanOrEqualTo(String value) {
            addCriterion("sale_service >=", value, "saleService");
            return (Criteria) this;
        }

        public Criteria andSaleServiceLessThan(String value) {
            addCriterion("sale_service <", value, "saleService");
            return (Criteria) this;
        }

        public Criteria andSaleServiceLessThanOrEqualTo(String value) {
            addCriterion("sale_service <=", value, "saleService");
            return (Criteria) this;
        }

        public Criteria andSaleServiceLike(String value) {
            addCriterion("sale_service like", value, "saleService");
            return (Criteria) this;
        }

        public Criteria andSaleServiceNotLike(String value) {
            addCriterion("sale_service not like", value, "saleService");
            return (Criteria) this;
        }

        public Criteria andSaleServiceIn(List<String> values) {
            addCriterion("sale_service in", values, "saleService");
            return (Criteria) this;
        }

        public Criteria andSaleServiceNotIn(List<String> values) {
            addCriterion("sale_service not in", values, "saleService");
            return (Criteria) this;
        }

        public Criteria andSaleServiceBetween(String value1, String value2) {
            addCriterion("sale_service between", value1, value2, "saleService");
            return (Criteria) this;
        }

        public Criteria andSaleServiceNotBetween(String value1, String value2) {
            addCriterion("sale_service not between", value1, value2, "saleService");
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