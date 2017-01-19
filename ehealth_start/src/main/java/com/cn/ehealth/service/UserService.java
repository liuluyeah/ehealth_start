package com.cn.ehealth.service;

import com.cn.ehealth.model.User;  
  
public interface UserService {  
    public User getUserById(int userId);  
    public boolean registerUser(User user);
}  