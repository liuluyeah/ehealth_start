package com.cn.ehealth.service;

import java.util.List;

import com.cn.ehealth.model.User;

public interface IUserService {

	public User getUserById(String id);
	
	public List<User> getAll();
}
