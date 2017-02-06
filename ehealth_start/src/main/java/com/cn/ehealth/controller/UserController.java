package com.cn.ehealth.controller;  
  
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;  
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;  
import org.springframework.ui.Model;  
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cn.ehealth.model.User;
import com.cn.ehealth.model.UserExample;
import com.cn.ehealth.service.UserService;


/*
 * 用户注册功能
 */

@Controller
public class UserController {  
   // @Resource
    @Autowired
    private UserService userService;  

    @RequestMapping("/showUser")  
    public String toIndex(HttpServletRequest request,Model model){  
       // int userId = Integer.parseInt(request.getParameter("id"));  
       // User user = this.userService.getUserById(userId);  
       // model.addAttribute("user", user);  
        return "login";  
    }  

    //第一步注册
    @RequestMapping(value = "/registerUserOne", method = RequestMethod.POST)
    @ResponseBody
    public Ajax registerUser(HttpServletRequest request, Model model,
            @RequestParam("tel") String tel,
            @RequestParam("pwd") String pwd,
            @RequestParam("d_p") String d_p) {
    	System.out.println("sdfsd");
        Ajax ajax = new Ajax();
        try {
        	User user = new User();
        	user.setTel(tel);
        	user.setPwd(pwd);
        	user.setdP(d_p);
        	boolean res = userService.registerUser(user);
        	if (res) {
        		ajax.setCode(Ajax.SUCCESS);
        		ajax.setMsg("添加成功！");
        	} else {
        		ajax.setCode(Ajax.EXIST);
        		ajax.setMsg("重复数据！");
        	}
        } catch (Exception e) {
            ajax.setCode(Ajax.ERROR);
            ajax.setMsg("数据库更新失败！");
        }
        return ajax;
    }
}  