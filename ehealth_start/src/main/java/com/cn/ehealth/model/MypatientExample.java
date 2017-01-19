package com.cn.ehealth.model;

import java.util.ArrayList;
import java.util.List;

public class MypatientExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MypatientExample() {
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

        public Criteria andIdmypatientIsNull() {
            addCriterion("idmypatient is null");
            return (Criteria) this;
        }

        public Criteria andIdmypatientIsNotNull() {
            addCriterion("idmypatient is not null");
            return (Criteria) this;
        }

        public Criteria andIdmypatientEqualTo(Integer value) {
            addCriterion("idmypatient =", value, "idmypatient");
            return (Criteria) this;
        }

        public Criteria andIdmypatientNotEqualTo(Integer value) {
            addCriterion("idmypatient <>", value, "idmypatient");
            return (Criteria) this;
        }

        public Criteria andIdmypatientGreaterThan(Integer value) {
            addCriterion("idmypatient >", value, "idmypatient");
            return (Criteria) this;
        }

        public Criteria andIdmypatientGreaterThanOrEqualTo(Integer value) {
            addCriterion("idmypatient >=", value, "idmypatient");
            return (Criteria) this;
        }

        public Criteria andIdmypatientLessThan(Integer value) {
            addCriterion("idmypatient <", value, "idmypatient");
            return (Criteria) this;
        }

        public Criteria andIdmypatientLessThanOrEqualTo(Integer value) {
            addCriterion("idmypatient <=", value, "idmypatient");
            return (Criteria) this;
        }

        public Criteria andIdmypatientIn(List<Integer> values) {
            addCriterion("idmypatient in", values, "idmypatient");
            return (Criteria) this;
        }

        public Criteria andIdmypatientNotIn(List<Integer> values) {
            addCriterion("idmypatient not in", values, "idmypatient");
            return (Criteria) this;
        }

        public Criteria andIdmypatientBetween(Integer value1, Integer value2) {
            addCriterion("idmypatient between", value1, value2, "idmypatient");
            return (Criteria) this;
        }

        public Criteria andIdmypatientNotBetween(Integer value1, Integer value2) {
            addCriterion("idmypatient not between", value1, value2, "idmypatient");
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

        public Criteria andSugarIsNull() {
            addCriterion("sugar is null");
            return (Criteria) this;
        }

        public Criteria andSugarIsNotNull() {
            addCriterion("sugar is not null");
            return (Criteria) this;
        }

        public Criteria andSugarEqualTo(String value) {
            addCriterion("sugar =", value, "sugar");
            return (Criteria) this;
        }

        public Criteria andSugarNotEqualTo(String value) {
            addCriterion("sugar <>", value, "sugar");
            return (Criteria) this;
        }

        public Criteria andSugarGreaterThan(String value) {
            addCriterion("sugar >", value, "sugar");
            return (Criteria) this;
        }

        public Criteria andSugarGreaterThanOrEqualTo(String value) {
            addCriterion("sugar >=", value, "sugar");
            return (Criteria) this;
        }

        public Criteria andSugarLessThan(String value) {
            addCriterion("sugar <", value, "sugar");
            return (Criteria) this;
        }

        public Criteria andSugarLessThanOrEqualTo(String value) {
            addCriterion("sugar <=", value, "sugar");
            return (Criteria) this;
        }

        public Criteria andSugarLike(String value) {
            addCriterion("sugar like", value, "sugar");
            return (Criteria) this;
        }

        public Criteria andSugarNotLike(String value) {
            addCriterion("sugar not like", value, "sugar");
            return (Criteria) this;
        }

        public Criteria andSugarIn(List<String> values) {
            addCriterion("sugar in", values, "sugar");
            return (Criteria) this;
        }

        public Criteria andSugarNotIn(List<String> values) {
            addCriterion("sugar not in", values, "sugar");
            return (Criteria) this;
        }

        public Criteria andSugarBetween(String value1, String value2) {
            addCriterion("sugar between", value1, value2, "sugar");
            return (Criteria) this;
        }

        public Criteria andSugarNotBetween(String value1, String value2) {
            addCriterion("sugar not between", value1, value2, "sugar");
            return (Criteria) this;
        }

        public Criteria andFatIsNull() {
            addCriterion("fat is null");
            return (Criteria) this;
        }

        public Criteria andFatIsNotNull() {
            addCriterion("fat is not null");
            return (Criteria) this;
        }

        public Criteria andFatEqualTo(String value) {
            addCriterion("fat =", value, "fat");
            return (Criteria) this;
        }

        public Criteria andFatNotEqualTo(String value) {
            addCriterion("fat <>", value, "fat");
            return (Criteria) this;
        }

        public Criteria andFatGreaterThan(String value) {
            addCriterion("fat >", value, "fat");
            return (Criteria) this;
        }

        public Criteria andFatGreaterThanOrEqualTo(String value) {
            addCriterion("fat >=", value, "fat");
            return (Criteria) this;
        }

        public Criteria andFatLessThan(String value) {
            addCriterion("fat <", value, "fat");
            return (Criteria) this;
        }

        public Criteria andFatLessThanOrEqualTo(String value) {
            addCriterion("fat <=", value, "fat");
            return (Criteria) this;
        }

        public Criteria andFatLike(String value) {
            addCriterion("fat like", value, "fat");
            return (Criteria) this;
        }

        public Criteria andFatNotLike(String value) {
            addCriterion("fat not like", value, "fat");
            return (Criteria) this;
        }

        public Criteria andFatIn(List<String> values) {
            addCriterion("fat in", values, "fat");
            return (Criteria) this;
        }

        public Criteria andFatNotIn(List<String> values) {
            addCriterion("fat not in", values, "fat");
            return (Criteria) this;
        }

        public Criteria andFatBetween(String value1, String value2) {
            addCriterion("fat between", value1, value2, "fat");
            return (Criteria) this;
        }

        public Criteria andFatNotBetween(String value1, String value2) {
            addCriterion("fat not between", value1, value2, "fat");
            return (Criteria) this;
        }

        public Criteria andBmiIsNull() {
            addCriterion("bmi is null");
            return (Criteria) this;
        }

        public Criteria andBmiIsNotNull() {
            addCriterion("bmi is not null");
            return (Criteria) this;
        }

        public Criteria andBmiEqualTo(String value) {
            addCriterion("bmi =", value, "bmi");
            return (Criteria) this;
        }

        public Criteria andBmiNotEqualTo(String value) {
            addCriterion("bmi <>", value, "bmi");
            return (Criteria) this;
        }

        public Criteria andBmiGreaterThan(String value) {
            addCriterion("bmi >", value, "bmi");
            return (Criteria) this;
        }

        public Criteria andBmiGreaterThanOrEqualTo(String value) {
            addCriterion("bmi >=", value, "bmi");
            return (Criteria) this;
        }

        public Criteria andBmiLessThan(String value) {
            addCriterion("bmi <", value, "bmi");
            return (Criteria) this;
        }

        public Criteria andBmiLessThanOrEqualTo(String value) {
            addCriterion("bmi <=", value, "bmi");
            return (Criteria) this;
        }

        public Criteria andBmiLike(String value) {
            addCriterion("bmi like", value, "bmi");
            return (Criteria) this;
        }

        public Criteria andBmiNotLike(String value) {
            addCriterion("bmi not like", value, "bmi");
            return (Criteria) this;
        }

        public Criteria andBmiIn(List<String> values) {
            addCriterion("bmi in", values, "bmi");
            return (Criteria) this;
        }

        public Criteria andBmiNotIn(List<String> values) {
            addCriterion("bmi not in", values, "bmi");
            return (Criteria) this;
        }

        public Criteria andBmiBetween(String value1, String value2) {
            addCriterion("bmi between", value1, value2, "bmi");
            return (Criteria) this;
        }

        public Criteria andBmiNotBetween(String value1, String value2) {
            addCriterion("bmi not between", value1, value2, "bmi");
            return (Criteria) this;
        }

        public Criteria andWaisthipratioIsNull() {
            addCriterion("waisthipratio is null");
            return (Criteria) this;
        }

        public Criteria andWaisthipratioIsNotNull() {
            addCriterion("waisthipratio is not null");
            return (Criteria) this;
        }

        public Criteria andWaisthipratioEqualTo(String value) {
            addCriterion("waisthipratio =", value, "waisthipratio");
            return (Criteria) this;
        }

        public Criteria andWaisthipratioNotEqualTo(String value) {
            addCriterion("waisthipratio <>", value, "waisthipratio");
            return (Criteria) this;
        }

        public Criteria andWaisthipratioGreaterThan(String value) {
            addCriterion("waisthipratio >", value, "waisthipratio");
            return (Criteria) this;
        }

        public Criteria andWaisthipratioGreaterThanOrEqualTo(String value) {
            addCriterion("waisthipratio >=", value, "waisthipratio");
            return (Criteria) this;
        }

        public Criteria andWaisthipratioLessThan(String value) {
            addCriterion("waisthipratio <", value, "waisthipratio");
            return (Criteria) this;
        }

        public Criteria andWaisthipratioLessThanOrEqualTo(String value) {
            addCriterion("waisthipratio <=", value, "waisthipratio");
            return (Criteria) this;
        }

        public Criteria andWaisthipratioLike(String value) {
            addCriterion("waisthipratio like", value, "waisthipratio");
            return (Criteria) this;
        }

        public Criteria andWaisthipratioNotLike(String value) {
            addCriterion("waisthipratio not like", value, "waisthipratio");
            return (Criteria) this;
        }

        public Criteria andWaisthipratioIn(List<String> values) {
            addCriterion("waisthipratio in", values, "waisthipratio");
            return (Criteria) this;
        }

        public Criteria andWaisthipratioNotIn(List<String> values) {
            addCriterion("waisthipratio not in", values, "waisthipratio");
            return (Criteria) this;
        }

        public Criteria andWaisthipratioBetween(String value1, String value2) {
            addCriterion("waisthipratio between", value1, value2, "waisthipratio");
            return (Criteria) this;
        }

        public Criteria andWaisthipratioNotBetween(String value1, String value2) {
            addCriterion("waisthipratio not between", value1, value2, "waisthipratio");
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

        public Criteria andMedicineIsNull() {
            addCriterion("medicine is null");
            return (Criteria) this;
        }

        public Criteria andMedicineIsNotNull() {
            addCriterion("medicine is not null");
            return (Criteria) this;
        }

        public Criteria andMedicineEqualTo(String value) {
            addCriterion("medicine =", value, "medicine");
            return (Criteria) this;
        }

        public Criteria andMedicineNotEqualTo(String value) {
            addCriterion("medicine <>", value, "medicine");
            return (Criteria) this;
        }

        public Criteria andMedicineGreaterThan(String value) {
            addCriterion("medicine >", value, "medicine");
            return (Criteria) this;
        }

        public Criteria andMedicineGreaterThanOrEqualTo(String value) {
            addCriterion("medicine >=", value, "medicine");
            return (Criteria) this;
        }

        public Criteria andMedicineLessThan(String value) {
            addCriterion("medicine <", value, "medicine");
            return (Criteria) this;
        }

        public Criteria andMedicineLessThanOrEqualTo(String value) {
            addCriterion("medicine <=", value, "medicine");
            return (Criteria) this;
        }

        public Criteria andMedicineLike(String value) {
            addCriterion("medicine like", value, "medicine");
            return (Criteria) this;
        }

        public Criteria andMedicineNotLike(String value) {
            addCriterion("medicine not like", value, "medicine");
            return (Criteria) this;
        }

        public Criteria andMedicineIn(List<String> values) {
            addCriterion("medicine in", values, "medicine");
            return (Criteria) this;
        }

        public Criteria andMedicineNotIn(List<String> values) {
            addCriterion("medicine not in", values, "medicine");
            return (Criteria) this;
        }

        public Criteria andMedicineBetween(String value1, String value2) {
            addCriterion("medicine between", value1, value2, "medicine");
            return (Criteria) this;
        }

        public Criteria andMedicineNotBetween(String value1, String value2) {
            addCriterion("medicine not between", value1, value2, "medicine");
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