package com.cn.ehealth.test;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.cn.ehealth.model.User;
import com.cn.ehealth.service.IUserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring.xml","classpath:spring-mybatis.xml"})
public class TestUser {
	
	private static final Logger logger = Logger.getLogger(TestUser.class);
	
	IUserService userService;

	public IUserService getUserService() {
		return userService;
	}
	@Autowired
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}
	@Test
	public void testGetUserById(){
		User user = userService.getUserById("0");
		logger.info(JSON.toJSONString(user));
//		System.out.println(user.getName());
//		System.out.println(user.getSex());
//		System.out.println(user.getTel());
//		System.out.println(user.getAddress());
		//数据库有日期格式的话
		//logger.info(JSON.toJSONStringWithDateFormat(user,"yyyy-MM-dd hh:mm:ss"));
	}
	@Test
	public void testGetAll(){
		List<User> list = userService.getAll();
		logger.info(JSON.toJSONString(list));
	}

}
