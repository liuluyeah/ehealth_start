package com.cn.ehealth.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.RequestContextHolder;
//import org.springframework.web.context.request.ServletRequestAttributes;

import com.cn.ehealth.controller.ServletRequestAttributes;;



public class SessionUtil {

	// 取得 request 及 session
	public static HttpSession getSession() {
		HttpSession session = null;
		try {
			session = getRequest().getSession();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return session;
	}

	public static HttpServletRequest getRequest() {
		ServletRequestAttributes attrs = (ServletRequestAttributes) RequestContextHolder
				.getRequestAttributes();
		return attrs.getRequest();
	}

	public static HttpServletResponse getResponse() {
		ServletRequestAttributes attrs = (ServletRequestAttributes) RequestContextHolder
				.getRequestAttributes();
		return attrs.getResponse();
	}

	public static String getCookie(String key) {
		Cookie[] cookies = getRequest().getCookies();
		for (Cookie c : cookies) {
			if (c.getName() == "key")
				return c.getValue();
		}
		return null;
	}

	public static void setCookie(String key, String value, int days, int hours) {
		Cookie c = new Cookie(key, value);
		c.setMaxAge(60 * 60 * (24 * days + hours));
		getResponse().addCookie(c);
	}
	
	
	public static LoginUser getLoginUser(){
		String sessionKey = LoginUser.SESSION_KEY;
		Object obj = getSession().getAttribute(sessionKey);
		if( obj instanceof LoginUser ){
			LoginUser loginUser = (LoginUser) obj;
			System.out.println("用户" + loginUser.getTel() + ":" +loginUser.getTel()
				+ "("+ loginUser.getId() + "." + loginUser.getName()+")"+ loginUser.getDp());
			return loginUser;
		}
		System.out.println("没有登录用户");
		return null;
	}

	public static Integer getLoginId(){
		LoginUser user = getLoginUser();
		if(user!=null) return user.getId();
		return null;
	}
	
	public static String getLoginTel(){
		LoginUser user = getLoginUser();
		if(user!=null) return user.getTel();
		return null;
	}
	
	
	public static String getLoginName(){
		LoginUser user = getLoginUser();
		if(user!=null) return user.getName();
		return null;
	}
	
	
	public static boolean isDoctor(){
		LoginUser user = getLoginUser(); 
		if(user==null) return false;
		return LoginUser.USER_TYPE_DOCTOR.equals(user.getDp());
	}	
	
	public static boolean isPatient(){
		LoginUser user = getLoginUser(); 
		if(user==null) return false;
		return LoginUser.USER_TYPE_PATIENT.equals(user.getDp());
	}	



}
