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
    public Ajax registerUserOne(HttpServletRequest request, Model model,
            @RequestParam("tel") String tel,
            @RequestParam("pwd") String pwd,
            @RequestParam("d_p") String d_p) {
        Ajax ajax = new Ajax();
        try {
        	User user = new User();
        	user.setTel(tel);
        	user.setPwd(pwd);
        	user.setdP(d_p);
        	boolean res = userService.registerUserOne(user);
        	if (res) {
        		int userid = userService.findUser(user.getTel());
        		ajax.setCode(Ajax.SUCCESS);
        		ajax.setMsg("添加成功！");
        		ajax.setResult(userid);
        	} else {
        		int userid = userService.findUser(user.getTel());
        		ajax.setCode(Ajax.EXIST);
        		ajax.setMsg("重复数据！");
        		ajax.setResult(userid);
        	}
        } catch (Exception e) {
            ajax.setCode(Ajax.ERROR);
            ajax.setMsg("数据库更新失败！");
        }
        return ajax;
    }
    
  //第二步注册
    @RequestMapping(value = "/registerUserTwo", method = RequestMethod.POST)
    @ResponseBody
    public Ajax registerUserTwo(HttpServletRequest request, Model model,
    		@RequestParam("id") Integer id,
            @RequestParam("name") String name,
            @RequestParam("sex") String sex,
            @RequestParam("birth") String birth,
            @RequestParam("age") Integer age,
            @RequestParam("identity") String identity,
            @RequestParam("recordNumber") String recordNumber) {
        Ajax ajax = new Ajax();
        try {
        	User user = userService.getUserById(id);
        	user.setName(name);
        	user.setSex(sex);
        	user.setBirth(birth);
        	user.setAge(age);
        	user.setIdentity(identity);
        	user.setRecordnumber(recordNumber);
        	boolean res = userService.updateUser(user);
        	if (res) {
        		ajax.setCode(Ajax.SUCCESS);
        		ajax.setMsg("添加成功！");
        		ajax.setResult(user.getdP());
        	} else {
        		ajax.setCode(Ajax.FAILURE);
        		ajax.setMsg("添加失败！");
        	}
        } catch (Exception e) {
            ajax.setCode(Ajax.ERROR);
            ajax.setMsg("数据库更新失败！");
        }
        return ajax;
    }
}  