package com.pinyougou.pojo;

import java.util.ArrayList;
import java.util.List;

public class TbContentCategoryExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbContentCategoryExample() {
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

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andContentGroupIsNull() {
            addCriterion("content_group is null");
            return (Criteria) this;
        }

        public Criteria andContentGroupIsNotNull() {
            addCriterion("content_group is not null");
            return (Criteria) this;
        }

        public Criteria andContentGroupEqualTo(String value) {
            addCriterion("content_group =", value, "contentGroup");
            return (Criteria) this;
        }

        public Criteria andContentGroupNotEqualTo(String value) {
            addCriterion("content_group <>", value, "contentGroup");
            return (Criteria) this;
        }

        public Criteria andContentGroupGreaterThan(String value) {
            addCriterion("content_group >", value, "contentGroup");
            return (Criteria) this;
        }

        public Criteria andContentGroupGreaterThanOrEqualTo(String value) {
            addCriterion("content_group >=", value, "contentGroup");
            return (Criteria) this;
        }

        public Criteria andContentGroupLessThan(String value) {
            addCriterion("content_group <", value, "contentGroup");
            return (Criteria) this;
        }

        public Criteria andContentGroupLessThanOrEqualTo(String value) {
            addCriterion("content_group <=", value, "contentGroup");
            return (Criteria) this;
        }

        public Criteria andContentGroupLike(String value) {
            addCriterion("content_group like", value, "contentGroup");
            return (Criteria) this;
        }

        public Criteria andContentGroupNotLike(String value) {
            addCriterion("content_group not like", value, "contentGroup");
            return (Criteria) this;
        }

        public Criteria andContentGroupIn(List<String> values) {
            addCriterion("content_group in", values, "contentGroup");
            return (Criteria) this;
        }

        public Criteria andContentGroupNotIn(List<String> values) {
            addCriterion("content_group not in", values, "contentGroup");
            return (Criteria) this;
        }

        public Criteria andContentGroupBetween(String value1, String value2) {
            addCriterion("content_group between", value1, value2, "contentGroup");
            return (Criteria) this;
        }

        public Criteria andContentGroupNotBetween(String value1, String value2) {
            addCriterion("content_group not between", value1, value2, "contentGroup");
            return (Criteria) this;
        }

        public Criteria andContentKeyIsNull() {
            addCriterion("content_key is null");
            return (Criteria) this;
        }

        public Criteria andContentKeyIsNotNull() {
            addCriterion("content_key is not null");
            return (Criteria) this;
        }

        public Criteria andContentKeyEqualTo(String value) {
            addCriterion("content_key =", value, "contentKey");
            return (Criteria) this;
        }

        public Criteria andContentKeyNotEqualTo(String value) {
            addCriterion("content_key <>", value, "contentKey");
            return (Criteria) this;
        }

        public Criteria andContentKeyGreaterThan(String value) {
            addCriterion("content_key >", value, "contentKey");
            return (Criteria) this;
        }

        public Criteria andContentKeyGreaterThanOrEqualTo(String value) {
            addCriterion("content_key >=", value, "contentKey");
            return (Criteria) this;
        }

        public Criteria andContentKeyLessThan(String value) {
            addCriterion("content_key <", value, "contentKey");
            return (Criteria) this;
        }

        public Criteria andContentKeyLessThanOrEqualTo(String value) {
            addCriterion("content_key <=", value, "contentKey");
            return (Criteria) this;
        }

        public Criteria andContentKeyLike(String value) {
            addCriterion("content_key like", value, "contentKey");
            return (Criteria) this;
        }

        public Criteria andContentKeyNotLike(String value) {
            addCriterion("content_key not like", value, "contentKey");
            return (Criteria) this;
        }

        public Criteria andContentKeyIn(List<String> values) {
            addCriterion("content_key in", values, "contentKey");
            return (Criteria) this;
        }

        public Criteria andContentKeyNotIn(List<String> values) {
            addCriterion("content_key not in", values, "contentKey");
            return (Criteria) this;
        }

        public Criteria andContentKeyBetween(String value1, String value2) {
            addCriterion("content_key between", value1, value2, "contentKey");
            return (Criteria) this;
        }

        public Criteria andContentKeyNotBetween(String value1, String value2) {
            addCriterion("content_key not between", value1, value2, "contentKey");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("status like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("status not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("status not between", value1, value2, "status");
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