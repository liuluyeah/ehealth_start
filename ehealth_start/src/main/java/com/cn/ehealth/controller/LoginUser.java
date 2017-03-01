
package com.cn.ehealth.controller;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class LoginUser implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public final static int LOGIN_FAILURE = 0;// 用户名或密码不正确
	public final static int LOGIN_SUCCESS = 1;// 登录成功
	public final static int LOGIN_USERNAME_OR_PASSWORD_EMPTY = 2;// 登录时，用户名或密码为空
	public final static int LOGIN_USER_NOT_FOUND = 3;// 登录时，登录用户不存在
	public final static int LOGIN_ACCOUNT_UNUSED = 4;// 账号不可用
	public final static int LOGIN_ACCOUNT_FREEZE = 5;// 账号已锁定，请30分钟后重试
	
	public final static String SESSION_KEY = "sessionUser";// 保存session用户信息
	
	public final static String USER_TYPE_DOCTOR = "doctor";// 医生
	public final static String USER_TYPE_PATIENT = "patient";// 患者
	
	private Integer code;// 返回调用结果
	private String msg;// 返回消息
	
	private Integer id;
	private String tel;
	private String name;
	private String dp;
	
	private String tickkey;// cookie中保存的登录令牌
	private List<String> rights;// 系统权限
	private Map<String, Object> params;// 扩展参数

	public String getTickkey() {
		return tickkey;
	}

	public void setTickkey(String tickkey) {
		this.tickkey = tickkey;
	}

	public List<String> getRights() {
		return rights;
	}

	public void setRights(List<String> rights) {
		this.rights = rights;
	}

	public Map<String, Object> getParams() {
		return params;
	}

	public void setParams(Map<String, Object> params) {
		this.params = params;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDp() {
		return dp;
	}

	public void setDp(String dp) {
		this.dp = dp;
	}


}