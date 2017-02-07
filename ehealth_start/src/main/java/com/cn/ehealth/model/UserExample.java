package com.cn.ehealth.model;

import java.util.ArrayList;
import java.util.List;

public class UserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserExample() {
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

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andTelIsNull() {
            addCriterion("tel is null");
            return (Criteria) this;
        }

        public Criteria andTelIsNotNull() {
            addCriterion("tel is not null");
            return (Criteria) this;
        }

        public Criteria andTelEqualTo(String value) {
            addCriterion("tel =", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelNotEqualTo(String value) {
            addCriterion("tel <>", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelGreaterThan(String value) {
            addCriterion("tel >", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelGreaterThanOrEqualTo(String value) {
            addCriterion("tel >=", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelLessThan(String value) {
            addCriterion("tel <", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelLessThanOrEqualTo(String value) {
            addCriterion("tel <=", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelLike(String value) {
            addCriterion("tel like", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelNotLike(String value) {
            addCriterion("tel not like", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelIn(List<String> values) {
            addCriterion("tel in", values, "tel");
            return (Criteria) this;
        }

        public Criteria andTelNotIn(List<String> values) {
            addCriterion("tel not in", values, "tel");
            return (Criteria) this;
        }

        public Criteria andTelBetween(String value1, String value2) {
            addCriterion("tel between", value1, value2, "tel");
            return (Criteria) this;
        }

        public Criteria andTelNotBetween(String value1, String value2) {
            addCriterion("tel not between", value1, value2, "tel");
            return (Criteria) this;
        }

        public Criteria andPwdIsNull() {
            addCriterion("pwd is null");
            return (Criteria) this;
        }

        public Criteria andPwdIsNotNull() {
            addCriterion("pwd is not null");
            return (Criteria) this;
        }

        public Criteria andPwdEqualTo(String value) {
            addCriterion("pwd =", value, "pwd");
            return (Criteria) this;
        }

        public Criteria andPwdNotEqualTo(String value) {
            addCriterion("pwd <>", value, "pwd");
            return (Criteria) this;
        }

        public Criteria andPwdGreaterThan(String value) {
            addCriterion("pwd >", value, "pwd");
            return (Criteria) this;
        }

        public Criteria andPwdGreaterThanOrEqualTo(String value) {
            addCriterion("pwd >=", value, "pwd");
            return (Criteria) this;
        }

        public Criteria andPwdLessThan(String value) {
            addCriterion("pwd <", value, "pwd");
            return (Criteria) this;
        }

        public Criteria andPwdLessThanOrEqualTo(String value) {
            addCriterion("pwd <=", value, "pwd");
            return (Criteria) this;
        }

        public Criteria andPwdLike(String value) {
            addCriterion("pwd like", value, "pwd");
            return (Criteria) this;
        }

        public Criteria andPwdNotLike(String value) {
            addCriterion("pwd not like", value, "pwd");
            return (Criteria) this;
        }

        public Criteria andPwdIn(List<String> values) {
            addCriterion("pwd in", values, "pwd");
            return (Criteria) this;
        }

        public Criteria andPwdNotIn(List<String> values) {
            addCriterion("pwd not in", values, "pwd");
            return (Criteria) this;
        }

        public Criteria andPwdBetween(String value1, String value2) {
            addCriterion("pwd between", value1, value2, "pwd");
            return (Criteria) this;
        }

        public Criteria andPwdNotBetween(String value1, String value2) {
            addCriterion("pwd not between", value1, value2, "pwd");
            return (Criteria) this;
        }

        public Criteria andChecknumIsNull() {
            addCriterion("checkNum is null");
            return (Criteria) this;
        }

        public Criteria andChecknumIsNotNull() {
            addCriterion("checkNum is not null");
            return (Criteria) this;
        }

        public Criteria andChecknumEqualTo(String value) {
            addCriterion("checkNum =", value, "checknum");
            return (Criteria) this;
        }

        public Criteria andChecknumNotEqualTo(String value) {
            addCriterion("checkNum <>", value, "checknum");
            return (Criteria) this;
        }

        public Criteria andChecknumGreaterThan(String value) {
            addCriterion("checkNum >", value, "checknum");
            return (Criteria) this;
        }

        public Criteria andChecknumGreaterThanOrEqualTo(String value) {
            addCriterion("checkNum >=", value, "checknum");
            return (Criteria) this;
        }

        public Criteria andChecknumLessThan(String value) {
            addCriterion("checkNum <", value, "checknum");
            return (Criteria) this;
        }

        public Criteria andChecknumLessThanOrEqualTo(String value) {
            addCriterion("checkNum <=", value, "checknum");
            return (Criteria) this;
        }

        public Criteria andChecknumLike(String value) {
            addCriterion("checkNum like", value, "checknum");
            return (Criteria) this;
        }

        public Criteria andChecknumNotLike(String value) {
            addCriterion("checkNum not like", value, "checknum");
            return (Criteria) this;
        }

        public Criteria andChecknumIn(List<String> values) {
            addCriterion("checkNum in", values, "checknum");
            return (Criteria) this;
        }

        public Criteria andChecknumNotIn(List<String> values) {
            addCriterion("checkNum not in", values, "checknum");
            return (Criteria) this;
        }

        public Criteria andChecknumBetween(String value1, String value2) {
            addCriterion("checkNum between", value1, value2, "checknum");
            return (Criteria) this;
        }

        public Criteria andChecknumNotBetween(String value1, String value2) {
            addCriterion("checkNum not between", value1, value2, "checknum");
            return (Criteria) this;
        }

        public Criteria andDPIsNull() {
            addCriterion("d_p is null");
            return (Criteria) this;
        }

        public Criteria andDPIsNotNull() {
            addCriterion("d_p is not null");
            return (Criteria) this;
        }

        public Criteria andDPEqualTo(String value) {
            addCriterion("d_p =", value, "dP");
            return (Criteria) this;
        }

        public Criteria andDPNotEqualTo(String value) {
            addCriterion("d_p <>", value, "dP");
            return (Criteria) this;
        }

        public Criteria andDPGreaterThan(String value) {
            addCriterion("d_p >", value, "dP");
            return (Criteria) this;
        }

        public Criteria andDPGreaterThanOrEqualTo(String value) {
            addCriterion("d_p >=", value, "dP");
            return (Criteria) this;
        }

        public Criteria andDPLessThan(String value) {
            addCriterion("d_p <", value, "dP");
            return (Criteria) this;
        }

        public Criteria andDPLessThanOrEqualTo(String value) {
            addCriterion("d_p <=", value, "dP");
            return (Criteria) this;
        }

        public Criteria andDPLike(String value) {
            addCriterion("d_p like", value, "dP");
            return (Criteria) this;
        }

        public Criteria andDPNotLike(String value) {
            addCriterion("d_p not like", value, "dP");
            return (Criteria) this;
        }

        public Criteria andDPIn(List<String> values) {
            addCriterion("d_p in", values, "dP");
            return (Criteria) this;
        }

        public Criteria andDPNotIn(List<String> values) {
            addCriterion("d_p not in", values, "dP");
            return (Criteria) this;
        }

        public Criteria andDPBetween(String value1, String value2) {
            addCriterion("d_p between", value1, value2, "dP");
            return (Criteria) this;
        }

        public Criteria andDPNotBetween(String value1, String value2) {
            addCriterion("d_p not between", value1, value2, "dP");
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

        public Criteria andSexIsNull() {
            addCriterion("sex is null");
            return (Criteria) this;
        }

        public Criteria andSexIsNotNull() {
            addCriterion("sex is not null");
            return (Criteria) this;
        }

        public Criteria andSexEqualTo(String value) {
            addCriterion("sex =", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotEqualTo(String value) {
            addCriterion("sex <>", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThan(String value) {
            addCriterion("sex >", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThanOrEqualTo(String value) {
            addCriterion("sex >=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThan(String value) {
            addCriterion("sex <", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThanOrEqualTo(String value) {
            addCriterion("sex <=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLike(String value) {
            addCriterion("sex like", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotLike(String value) {
            addCriterion("sex not like", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexIn(List<String> values) {
            addCriterion("sex in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotIn(List<String> values) {
            addCriterion("sex not in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexBetween(String value1, String value2) {
            addCriterion("sex between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotBetween(String value1, String value2) {
            addCriterion("sex not between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andBirthIsNull() {
            addCriterion("birth is null");
            return (Criteria) this;
        }

        public Criteria andBirthIsNotNull() {
            addCriterion("birth is not null");
            return (Criteria) this;
        }

        public Criteria andBirthEqualTo(String value) {
            addCriterion("birth =", value, "birth");
            return (Criteria) this;
        }

        public Criteria andBirthNotEqualTo(String value) {
            addCriterion("birth <>", value, "birth");
            return (Criteria) this;
        }

        public Criteria andBirthGreaterThan(String value) {
            addCriterion("birth >", value, "birth");
            return (Criteria) this;
        }

        public Criteria andBirthGreaterThanOrEqualTo(String value) {
            addCriterion("birth >=", value, "birth");
            return (Criteria) this;
        }

        public Criteria andBirthLessThan(String value) {
            addCriterion("birth <", value, "birth");
            return (Criteria) this;
        }

        public Criteria andBirthLessThanOrEqualTo(String value) {
            addCriterion("birth <=", value, "birth");
            return (Criteria) this;
        }

        public Criteria andBirthLike(String value) {
            addCriterion("birth like", value, "birth");
            return (Criteria) this;
        }

        public Criteria andBirthNotLike(String value) {
            addCriterion("birth not like", value, "birth");
            return (Criteria) this;
        }

        public Criteria andBirthIn(List<String> values) {
            addCriterion("birth in", values, "birth");
            return (Criteria) this;
        }

        public Criteria andBirthNotIn(List<String> values) {
            addCriterion("birth not in", values, "birth");
            return (Criteria) this;
        }

        public Criteria andBirthBetween(String value1, String value2) {
            addCriterion("birth between", value1, value2, "birth");
            return (Criteria) this;
        }

        public Criteria andBirthNotBetween(String value1, String value2) {
            addCriterion("birth not between", value1, value2, "birth");
            return (Criteria) this;
        }

        public Criteria andAgeIsNull() {
            addCriterion("age is null");
            return (Criteria) this;
        }

        public Criteria andAgeIsNotNull() {
            addCriterion("age is not null");
            return (Criteria) this;
        }

        public Criteria andAgeEqualTo(Integer value) {
            addCriterion("age =", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeNotEqualTo(Integer value) {
            addCriterion("age <>", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeGreaterThan(Integer value) {
            addCriterion("age >", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeGreaterThanOrEqualTo(Integer value) {
            addCriterion("age >=", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeLessThan(Integer value) {
            addCriterion("age <", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeLessThanOrEqualTo(Integer value) {
            addCriterion("age <=", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeIn(List<Integer> values) {
            addCriterion("age in", values, "age");
            return (Criteria) this;
        }

        public Criteria andAgeNotIn(List<Integer> values) {
            addCriterion("age not in", values, "age");
            return (Criteria) this;
        }

        public Criteria andAgeBetween(Integer value1, Integer value2) {
            addCriterion("age between", value1, value2, "age");
            return (Criteria) this;
        }

        public Criteria andAgeNotBetween(Integer value1, Integer value2) {
            addCriterion("age not between", value1, value2, "age");
            return (Criteria) this;
        }

        public Criteria andIdentityIsNull() {
            addCriterion("identity is null");
            return (Criteria) this;
        }

        public Criteria andIdentityIsNotNull() {
            addCriterion("identity is not null");
            return (Criteria) this;
        }

        public Criteria andIdentityEqualTo(String value) {
            addCriterion("identity =", value, "identity");
            return (Criteria) this;
        }

        public Criteria andIdentityNotEqualTo(String value) {
            addCriterion("identity <>", value, "identity");
            return (Criteria) this;
        }

        public Criteria andIdentityGreaterThan(String value) {
            addCriterion("identity >", value, "identity");
            return (Criteria) this;
        }

        public Criteria andIdentityGreaterThanOrEqualTo(String value) {
            addCriterion("identity >=", value, "identity");
            return (Criteria) this;
        }

        public Criteria andIdentityLessThan(String value) {
            addCriterion("identity <", value, "identity");
            return (Criteria) this;
        }

        public Criteria andIdentityLessThanOrEqualTo(String value) {
            addCriterion("identity <=", value, "identity");
            return (Criteria) this;
        }

        public Criteria andIdentityLike(String value) {
            addCriterion("identity like", value, "identity");
            return (Criteria) this;
        }

        public Criteria andIdentityNotLike(String value) {
            addCriterion("identity not like", value, "identity");
            return (Criteria) this;
        }

        public Criteria andIdentityIn(List<String> values) {
            addCriterion("identity in", values, "identity");
            return (Criteria) this;
        }

        public Criteria andIdentityNotIn(List<String> values) {
            addCriterion("identity not in", values, "identity");
            return (Criteria) this;
        }

        public Criteria andIdentityBetween(String value1, String value2) {
            addCriterion("identity between", value1, value2, "identity");
            return (Criteria) this;
        }

        public Criteria andIdentityNotBetween(String value1, String value2) {
            addCriterion("identity not between", value1, value2, "identity");
            return (Criteria) this;
        }

        public Criteria andRecordnumberIsNull() {
            addCriterion("recordNumber is null");
            return (Criteria) this;
        }

        public Criteria andRecordnumberIsNotNull() {
            addCriterion("recordNumber is not null");
            return (Criteria) this;
        }

        public Criteria andRecordnumberEqualTo(String value) {
            addCriterion("recordNumber =", value, "recordnumber");
            return (Criteria) this;
        }

        public Criteria andRecordnumberNotEqualTo(String value) {
            addCriterion("recordNumber <>", value, "recordnumber");
            return (Criteria) this;
        }

        public Criteria andRecordnumberGreaterThan(String value) {
            addCriterion("recordNumber >", value, "recordnumber");
            return (Criteria) this;
        }

        public Criteria andRecordnumberGreaterThanOrEqualTo(String value) {
            addCriterion("recordNumber >=", value, "recordnumber");
            return (Criteria) this;
        }

        public Criteria andRecordnumberLessThan(String value) {
            addCriterion("recordNumber <", value, "recordnumber");
            return (Criteria) this;
        }

        public Criteria andRecordnumberLessThanOrEqualTo(String value) {
            addCriterion("recordNumber <=", value, "recordnumber");
            return (Criteria) this;
        }

        public Criteria andRecordnumberLike(String value) {
            addCriterion("recordNumber like", value, "recordnumber");
            return (Criteria) this;
        }

        public Criteria andRecordnumberNotLike(String value) {
            addCriterion("recordNumber not like", value, "recordnumber");
            return (Criteria) this;
        }

        public Criteria andRecordnumberIn(List<String> values) {
            addCriterion("recordNumber in", values, "recordnumber");
            return (Criteria) this;
        }

        public Criteria andRecordnumberNotIn(List<String> values) {
            addCriterion("recordNumber not in", values, "recordnumber");
            return (Criteria) this;
        }

        public Criteria andRecordnumberBetween(String value1, String value2) {
            addCriterion("recordNumber between", value1, value2, "recordnumber");
            return (Criteria) this;
        }

        public Criteria andRecordnumberNotBetween(String value1, String value2) {
            addCriterion("recordNumber not between", value1, value2, "recordnumber");
            return (Criteria) this;
        }

        public Criteria andDoctimeIsNull() {
            addCriterion("docTime is null");
            return (Criteria) this;
        }

        public Criteria andDoctimeIsNotNull() {
            addCriterion("docTime is not null");
            return (Criteria) this;
        }

        public Criteria andDoctimeEqualTo(String value) {
            addCriterion("docTime =", value, "doctime");
            return (Criteria) this;
        }

        public Criteria andDoctimeNotEqualTo(String value) {
            addCriterion("docTime <>", value, "doctime");
            return (Criteria) this;
        }

        public Criteria andDoctimeGreaterThan(String value) {
            addCriterion("docTime >", value, "doctime");
            return (Criteria) this;
        }

        public Criteria andDoctimeGreaterThanOrEqualTo(String value) {
            addCriterion("docTime >=", value, "doctime");
            return (Criteria) this;
        }

        public Criteria andDoctimeLessThan(String value) {
            addCriterion("docTime <", value, "doctime");
            return (Criteria) this;
        }

        public Criteria andDoctimeLessThanOrEqualTo(String value) {
            addCriterion("docTime <=", value, "doctime");
            return (Criteria) this;
        }

        public Criteria andDoctimeLike(String value) {
            addCriterion("docTime like", value, "doctime");
            return (Criteria) this;
        }

        public Criteria andDoctimeNotLike(String value) {
            addCriterion("docTime not like", value, "doctime");
            return (Criteria) this;
        }

        public Criteria andDoctimeIn(List<String> values) {
            addCriterion("docTime in", values, "doctime");
            return (Criteria) this;
        }

        public Criteria andDoctimeNotIn(List<String> values) {
            addCriterion("docTime not in", values, "doctime");
            return (Criteria) this;
        }

        public Criteria andDoctimeBetween(String value1, String value2) {
            addCriterion("docTime between", value1, value2, "doctime");
            return (Criteria) this;
        }

        public Criteria andDoctimeNotBetween(String value1, String value2) {
            addCriterion("docTime not between", value1, value2, "doctime");
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