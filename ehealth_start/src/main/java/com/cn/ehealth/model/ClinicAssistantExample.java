package com.cn.ehealth.model;

import java.util.ArrayList;
import java.util.List;

public class ClinicAssistantExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ClinicAssistantExample() {
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

        public Criteria andIdmenzhenIsNull() {
            addCriterion("idmenzhen is null");
            return (Criteria) this;
        }

        public Criteria andIdmenzhenIsNotNull() {
            addCriterion("idmenzhen is not null");
            return (Criteria) this;
        }

        public Criteria andIdmenzhenEqualTo(Integer value) {
            addCriterion("idmenzhen =", value, "idmenzhen");
            return (Criteria) this;
        }

        public Criteria andIdmenzhenNotEqualTo(Integer value) {
            addCriterion("idmenzhen <>", value, "idmenzhen");
            return (Criteria) this;
        }

        public Criteria andIdmenzhenGreaterThan(Integer value) {
            addCriterion("idmenzhen >", value, "idmenzhen");
            return (Criteria) this;
        }

        public Criteria andIdmenzhenGreaterThanOrEqualTo(Integer value) {
            addCriterion("idmenzhen >=", value, "idmenzhen");
            return (Criteria) this;
        }

        public Criteria andIdmenzhenLessThan(Integer value) {
            addCriterion("idmenzhen <", value, "idmenzhen");
            return (Criteria) this;
        }

        public Criteria andIdmenzhenLessThanOrEqualTo(Integer value) {
            addCriterion("idmenzhen <=", value, "idmenzhen");
            return (Criteria) this;
        }

        public Criteria andIdmenzhenIn(List<Integer> values) {
            addCriterion("idmenzhen in", values, "idmenzhen");
            return (Criteria) this;
        }

        public Criteria andIdmenzhenNotIn(List<Integer> values) {
            addCriterion("idmenzhen not in", values, "idmenzhen");
            return (Criteria) this;
        }

        public Criteria andIdmenzhenBetween(Integer value1, Integer value2) {
            addCriterion("idmenzhen between", value1, value2, "idmenzhen");
            return (Criteria) this;
        }

        public Criteria andIdmenzhenNotBetween(Integer value1, Integer value2) {
            addCriterion("idmenzhen not between", value1, value2, "idmenzhen");
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

        public Criteria andTimeIsNull() {
            addCriterion("time is null");
            return (Criteria) this;
        }

        public Criteria andTimeIsNotNull() {
            addCriterion("time is not null");
            return (Criteria) this;
        }

        public Criteria andTimeEqualTo(String value) {
            addCriterion("time =", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotEqualTo(String value) {
            addCriterion("time <>", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeGreaterThan(String value) {
            addCriterion("time >", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeGreaterThanOrEqualTo(String value) {
            addCriterion("time >=", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLessThan(String value) {
            addCriterion("time <", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLessThanOrEqualTo(String value) {
            addCriterion("time <=", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLike(String value) {
            addCriterion("time like", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotLike(String value) {
            addCriterion("time not like", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeIn(List<String> values) {
            addCriterion("time in", values, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotIn(List<String> values) {
            addCriterion("time not in", values, "time");
            return (Criteria) this;
        }

        public Criteria andTimeBetween(String value1, String value2) {
            addCriterion("time between", value1, value2, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotBetween(String value1, String value2) {
            addCriterion("time not between", value1, value2, "time");
            return (Criteria) this;
        }

        public Criteria andMainreasonIsNull() {
            addCriterion("mainreason is null");
            return (Criteria) this;
        }

        public Criteria andMainreasonIsNotNull() {
            addCriterion("mainreason is not null");
            return (Criteria) this;
        }

        public Criteria andMainreasonEqualTo(String value) {
            addCriterion("mainreason =", value, "mainreason");
            return (Criteria) this;
        }

        public Criteria andMainreasonNotEqualTo(String value) {
            addCriterion("mainreason <>", value, "mainreason");
            return (Criteria) this;
        }

        public Criteria andMainreasonGreaterThan(String value) {
            addCriterion("mainreason >", value, "mainreason");
            return (Criteria) this;
        }

        public Criteria andMainreasonGreaterThanOrEqualTo(String value) {
            addCriterion("mainreason >=", value, "mainreason");
            return (Criteria) this;
        }

        public Criteria andMainreasonLessThan(String value) {
            addCriterion("mainreason <", value, "mainreason");
            return (Criteria) this;
        }

        public Criteria andMainreasonLessThanOrEqualTo(String value) {
            addCriterion("mainreason <=", value, "mainreason");
            return (Criteria) this;
        }

        public Criteria andMainreasonLike(String value) {
            addCriterion("mainreason like", value, "mainreason");
            return (Criteria) this;
        }

        public Criteria andMainreasonNotLike(String value) {
            addCriterion("mainreason not like", value, "mainreason");
            return (Criteria) this;
        }

        public Criteria andMainreasonIn(List<String> values) {
            addCriterion("mainreason in", values, "mainreason");
            return (Criteria) this;
        }

        public Criteria andMainreasonNotIn(List<String> values) {
            addCriterion("mainreason not in", values, "mainreason");
            return (Criteria) this;
        }

        public Criteria andMainreasonBetween(String value1, String value2) {
            addCriterion("mainreason between", value1, value2, "mainreason");
            return (Criteria) this;
        }

        public Criteria andMainreasonNotBetween(String value1, String value2) {
            addCriterion("mainreason not between", value1, value2, "mainreason");
            return (Criteria) this;
        }

        public Criteria andHeightIsNull() {
            addCriterion("height is null");
            return (Criteria) this;
        }

        public Criteria andHeightIsNotNull() {
            addCriterion("height is not null");
            return (Criteria) this;
        }

        public Criteria andHeightEqualTo(String value) {
            addCriterion("height =", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightNotEqualTo(String value) {
            addCriterion("height <>", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightGreaterThan(String value) {
            addCriterion("height >", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightGreaterThanOrEqualTo(String value) {
            addCriterion("height >=", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightLessThan(String value) {
            addCriterion("height <", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightLessThanOrEqualTo(String value) {
            addCriterion("height <=", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightLike(String value) {
            addCriterion("height like", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightNotLike(String value) {
            addCriterion("height not like", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightIn(List<String> values) {
            addCriterion("height in", values, "height");
            return (Criteria) this;
        }

        public Criteria andHeightNotIn(List<String> values) {
            addCriterion("height not in", values, "height");
            return (Criteria) this;
        }

        public Criteria andHeightBetween(String value1, String value2) {
            addCriterion("height between", value1, value2, "height");
            return (Criteria) this;
        }

        public Criteria andHeightNotBetween(String value1, String value2) {
            addCriterion("height not between", value1, value2, "height");
            return (Criteria) this;
        }

        public Criteria andWeigthtIsNull() {
            addCriterion("weigtht is null");
            return (Criteria) this;
        }

        public Criteria andWeigthtIsNotNull() {
            addCriterion("weigtht is not null");
            return (Criteria) this;
        }

        public Criteria andWeigthtEqualTo(String value) {
            addCriterion("weigtht =", value, "weigtht");
            return (Criteria) this;
        }

        public Criteria andWeigthtNotEqualTo(String value) {
            addCriterion("weigtht <>", value, "weigtht");
            return (Criteria) this;
        }

        public Criteria andWeigthtGreaterThan(String value) {
            addCriterion("weigtht >", value, "weigtht");
            return (Criteria) this;
        }

        public Criteria andWeigthtGreaterThanOrEqualTo(String value) {
            addCriterion("weigtht >=", value, "weigtht");
            return (Criteria) this;
        }

        public Criteria andWeigthtLessThan(String value) {
            addCriterion("weigtht <", value, "weigtht");
            return (Criteria) this;
        }

        public Criteria andWeigthtLessThanOrEqualTo(String value) {
            addCriterion("weigtht <=", value, "weigtht");
            return (Criteria) this;
        }

        public Criteria andWeigthtLike(String value) {
            addCriterion("weigtht like", value, "weigtht");
            return (Criteria) this;
        }

        public Criteria andWeigthtNotLike(String value) {
            addCriterion("weigtht not like", value, "weigtht");
            return (Criteria) this;
        }

        public Criteria andWeigthtIn(List<String> values) {
            addCriterion("weigtht in", values, "weigtht");
            return (Criteria) this;
        }

        public Criteria andWeigthtNotIn(List<String> values) {
            addCriterion("weigtht not in", values, "weigtht");
            return (Criteria) this;
        }

        public Criteria andWeigthtBetween(String value1, String value2) {
            addCriterion("weigtht between", value1, value2, "weigtht");
            return (Criteria) this;
        }

        public Criteria andWeigthtNotBetween(String value1, String value2) {
            addCriterion("weigtht not between", value1, value2, "weigtht");
            return (Criteria) this;
        }

        public Criteria andBloodpressureIsNull() {
            addCriterion("bloodpressure is null");
            return (Criteria) this;
        }

        public Criteria andBloodpressureIsNotNull() {
            addCriterion("bloodpressure is not null");
            return (Criteria) this;
        }

        public Criteria andBloodpressureEqualTo(String value) {
            addCriterion("bloodpressure =", value, "bloodpressure");
            return (Criteria) this;
        }

        public Criteria andBloodpressureNotEqualTo(String value) {
            addCriterion("bloodpressure <>", value, "bloodpressure");
            return (Criteria) this;
        }

        public Criteria andBloodpressureGreaterThan(String value) {
            addCriterion("bloodpressure >", value, "bloodpressure");
            return (Criteria) this;
        }

        public Criteria andBloodpressureGreaterThanOrEqualTo(String value) {
            addCriterion("bloodpressure >=", value, "bloodpressure");
            return (Criteria) this;
        }

        public Criteria andBloodpressureLessThan(String value) {
            addCriterion("bloodpressure <", value, "bloodpressure");
            return (Criteria) this;
        }

        public Criteria andBloodpressureLessThanOrEqualTo(String value) {
            addCriterion("bloodpressure <=", value, "bloodpressure");
            return (Criteria) this;
        }

        public Criteria andBloodpressureLike(String value) {
            addCriterion("bloodpressure like", value, "bloodpressure");
            return (Criteria) this;
        }

        public Criteria andBloodpressureNotLike(String value) {
            addCriterion("bloodpressure not like", value, "bloodpressure");
            return (Criteria) this;
        }

        public Criteria andBloodpressureIn(List<String> values) {
            addCriterion("bloodpressure in", values, "bloodpressure");
            return (Criteria) this;
        }

        public Criteria andBloodpressureNotIn(List<String> values) {
            addCriterion("bloodpressure not in", values, "bloodpressure");
            return (Criteria) this;
        }

        public Criteria andBloodpressureBetween(String value1, String value2) {
            addCriterion("bloodpressure between", value1, value2, "bloodpressure");
            return (Criteria) this;
        }

        public Criteria andBloodpressureNotBetween(String value1, String value2) {
            addCriterion("bloodpressure not between", value1, value2, "bloodpressure");
            return (Criteria) this;
        }

        public Criteria andWaistIsNull() {
            addCriterion("waist is null");
            return (Criteria) this;
        }

        public Criteria andWaistIsNotNull() {
            addCriterion("waist is not null");
            return (Criteria) this;
        }

        public Criteria andWaistEqualTo(String value) {
            addCriterion("waist =", value, "waist");
            return (Criteria) this;
        }

        public Criteria andWaistNotEqualTo(String value) {
            addCriterion("waist <>", value, "waist");
            return (Criteria) this;
        }

        public Criteria andWaistGreaterThan(String value) {
            addCriterion("waist >", value, "waist");
            return (Criteria) this;
        }

        public Criteria andWaistGreaterThanOrEqualTo(String value) {
            addCriterion("waist >=", value, "waist");
            return (Criteria) this;
        }

        public Criteria andWaistLessThan(String value) {
            addCriterion("waist <", value, "waist");
            return (Criteria) this;
        }

        public Criteria andWaistLessThanOrEqualTo(String value) {
            addCriterion("waist <=", value, "waist");
            return (Criteria) this;
        }

        public Criteria andWaistLike(String value) {
            addCriterion("waist like", value, "waist");
            return (Criteria) this;
        }

        public Criteria andWaistNotLike(String value) {
            addCriterion("waist not like", value, "waist");
            return (Criteria) this;
        }

        public Criteria andWaistIn(List<String> values) {
            addCriterion("waist in", values, "waist");
            return (Criteria) this;
        }

        public Criteria andWaistNotIn(List<String> values) {
            addCriterion("waist not in", values, "waist");
            return (Criteria) this;
        }

        public Criteria andWaistBetween(String value1, String value2) {
            addCriterion("waist between", value1, value2, "waist");
            return (Criteria) this;
        }

        public Criteria andWaistNotBetween(String value1, String value2) {
            addCriterion("waist not between", value1, value2, "waist");
            return (Criteria) this;
        }

        public Criteria andHipIsNull() {
            addCriterion("hip is null");
            return (Criteria) this;
        }

        public Criteria andHipIsNotNull() {
            addCriterion("hip is not null");
            return (Criteria) this;
        }

        public Criteria andHipEqualTo(String value) {
            addCriterion("hip =", value, "hip");
            return (Criteria) this;
        }

        public Criteria andHipNotEqualTo(String value) {
            addCriterion("hip <>", value, "hip");
            return (Criteria) this;
        }

        public Criteria andHipGreaterThan(String value) {
            addCriterion("hip >", value, "hip");
            return (Criteria) this;
        }

        public Criteria andHipGreaterThanOrEqualTo(String value) {
            addCriterion("hip >=", value, "hip");
            return (Criteria) this;
        }

        public Criteria andHipLessThan(String value) {
            addCriterion("hip <", value, "hip");
            return (Criteria) this;
        }

        public Criteria andHipLessThanOrEqualTo(String value) {
            addCriterion("hip <=", value, "hip");
            return (Criteria) this;
        }

        public Criteria andHipLike(String value) {
            addCriterion("hip like", value, "hip");
            return (Criteria) this;
        }

        public Criteria andHipNotLike(String value) {
            addCriterion("hip not like", value, "hip");
            return (Criteria) this;
        }

        public Criteria andHipIn(List<String> values) {
            addCriterion("hip in", values, "hip");
            return (Criteria) this;
        }

        public Criteria andHipNotIn(List<String> values) {
            addCriterion("hip not in", values, "hip");
            return (Criteria) this;
        }

        public Criteria andHipBetween(String value1, String value2) {
            addCriterion("hip between", value1, value2, "hip");
            return (Criteria) this;
        }

        public Criteria andHipNotBetween(String value1, String value2) {
            addCriterion("hip not between", value1, value2, "hip");
            return (Criteria) this;
        }

        public Criteria andClassificationIsNull() {
            addCriterion("classification is null");
            return (Criteria) this;
        }

        public Criteria andClassificationIsNotNull() {
            addCriterion("classification is not null");
            return (Criteria) this;
        }

        public Criteria andClassificationEqualTo(String value) {
            addCriterion("classification =", value, "classification");
            return (Criteria) this;
        }

        public Criteria andClassificationNotEqualTo(String value) {
            addCriterion("classification <>", value, "classification");
            return (Criteria) this;
        }

        public Criteria andClassificationGreaterThan(String value) {
            addCriterion("classification >", value, "classification");
            return (Criteria) this;
        }

        public Criteria andClassificationGreaterThanOrEqualTo(String value) {
            addCriterion("classification >=", value, "classification");
            return (Criteria) this;
        }

        public Criteria andClassificationLessThan(String value) {
            addCriterion("classification <", value, "classification");
            return (Criteria) this;
        }

        public Criteria andClassificationLessThanOrEqualTo(String value) {
            addCriterion("classification <=", value, "classification");
            return (Criteria) this;
        }

        public Criteria andClassificationLike(String value) {
            addCriterion("classification like", value, "classification");
            return (Criteria) this;
        }

        public Criteria andClassificationNotLike(String value) {
            addCriterion("classification not like", value, "classification");
            return (Criteria) this;
        }

        public Criteria andClassificationIn(List<String> values) {
            addCriterion("classification in", values, "classification");
            return (Criteria) this;
        }

        public Criteria andClassificationNotIn(List<String> values) {
            addCriterion("classification not in", values, "classification");
            return (Criteria) this;
        }

        public Criteria andClassificationBetween(String value1, String value2) {
            addCriterion("classification between", value1, value2, "classification");
            return (Criteria) this;
        }

        public Criteria andClassificationNotBetween(String value1, String value2) {
            addCriterion("classification not between", value1, value2, "classification");
            return (Criteria) this;
        }

        public Criteria andDivideIsNull() {
            addCriterion("divide is null");
            return (Criteria) this;
        }

        public Criteria andDivideIsNotNull() {
            addCriterion("divide is not null");
            return (Criteria) this;
        }

        public Criteria andDivideEqualTo(String value) {
            addCriterion("divide =", value, "divide");
            return (Criteria) this;
        }

        public Criteria andDivideNotEqualTo(String value) {
            addCriterion("divide <>", value, "divide");
            return (Criteria) this;
        }

        public Criteria andDivideGreaterThan(String value) {
            addCriterion("divide >", value, "divide");
            return (Criteria) this;
        }

        public Criteria andDivideGreaterThanOrEqualTo(String value) {
            addCriterion("divide >=", value, "divide");
            return (Criteria) this;
        }

        public Criteria andDivideLessThan(String value) {
            addCriterion("divide <", value, "divide");
            return (Criteria) this;
        }

        public Criteria andDivideLessThanOrEqualTo(String value) {
            addCriterion("divide <=", value, "divide");
            return (Criteria) this;
        }

        public Criteria andDivideLike(String value) {
            addCriterion("divide like", value, "divide");
            return (Criteria) this;
        }

        public Criteria andDivideNotLike(String value) {
            addCriterion("divide not like", value, "divide");
            return (Criteria) this;
        }

        public Criteria andDivideIn(List<String> values) {
            addCriterion("divide in", values, "divide");
            return (Criteria) this;
        }

        public Criteria andDivideNotIn(List<String> values) {
            addCriterion("divide not in", values, "divide");
            return (Criteria) this;
        }

        public Criteria andDivideBetween(String value1, String value2) {
            addCriterion("divide between", value1, value2, "divide");
            return (Criteria) this;
        }

        public Criteria andDivideNotBetween(String value1, String value2) {
            addCriterion("divide not between", value1, value2, "divide");
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