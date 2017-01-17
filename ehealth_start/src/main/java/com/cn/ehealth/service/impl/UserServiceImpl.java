package com.cn.ehealth.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.ehealth.dao.UserMapper;
import com.cn.ehealth.model.User;
import com.cn.ehealth.service.UserService;


@Service
public class UserServiceImpl implements UserService{
	@Autowired
    private UserMapper userDao;

	public boolean registerUser (User user) {
        int result = userDao.insert(user);
        if (result > 0) {
            return true;
        }
        return false;
    }
}
