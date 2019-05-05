package com.layui.dao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.layui.dao.entity.User;
import com.layui.dao.service.IUserService;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author zhulin
 * @since 2019-03-21
 */
//json 接口开发，spring boot只需要类添加  @RestController  即可，默认类中的方法都会以json的格式返回
@RestController
@RequestMapping(value = "/dao/user")
public class UserController {
	@Autowired
	private IUserService userSvc;

	//神坑，这里用了RequestMapping后一直报错：spring boot No mapping for GET 
	@GetMapping(value = "/show")
	public JSONObject testEnum() {
		//此处  userSvc.selectPage 返回类型是接口，所以要强制转换
		Page<User> users = (Page<User>) userSvc.selectPage(new Page<>(1, 10), "aa123456");
		JSONObject result = new JSONObject();
		result.put("users", users);
		return result;
	}
	
	//神坑，这里用了RequestMapping 后一直报错：spring boot No mapping for GET 
	@GetMapping(value = "/show2")
	public Page<User> testEnum2() {
		Page<User> users = (Page<User>) userSvc.selectPage(new Page<>(1, 10), "aa123456");
		return users;
	}
}