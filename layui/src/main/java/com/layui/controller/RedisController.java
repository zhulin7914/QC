package com.layui.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.layui.common.other.JsonUtil;
import com.layui.common.rabbitMQ.sender.MsgSender;
import com.layui.dao.entity.User;

@RestController
@RequestMapping(value = "/redis")  
public class RedisController {
	
	@Autowired
	private RedisTemplate redisTemplate;
	
	@Autowired
	private MsgSender msgSender;
	
	@RequestMapping(value ="/add")
	@ResponseBody
	public String addUser () throws Exception{
		//插入一条数据
		User user = new User();
        user.setUserName("a1");
        user.setId("8");
        user.setEmail("a1@123.com");
        user.setNickName("管理员1");
        user.setPassWord("123456");
        user.setRegTime("2019-04-12");
        //将数据写入redis-使用string类型
        String jsonString =JsonUtil.generate(user);
        redisTemplate.opsForValue().set("a1",jsonString);
        //发送消息队列，让将redis数据写入数据库
		msgSender.sendMsgB("a1");
		return "新增用户成功！";
	}
	
	@RequestMapping(value ="/add1")
	@ResponseBody
	public String addUser1 () throws Exception{
		//插入一条数据
		User user = new User();
        user.setUserName("a2");
        user.setId("9");
        user.setEmail("a2@123.com");
        user.setNickName("管理员2");
        user.setPassWord("123456");
        user.setRegTime("2019-04-12");
        //将数据写入redis-使用hash类型
       	HashOperations<String, String, String> map=redisTemplate.opsForHash();
       	//向键名为stu.getStuid的map对象存储key-value对
       	map.put("a2", "id", user.getId());
       	map.put("a2", "email", user.getEmail());
       	map.put("a2", "nickName", user.getNickName());
       	map.put("a2", "passWord", user.getPassWord());
       	map.put("a2", "regTime", user.getRegTime());
       	map.put("a2", "userName", user.getUserName());
        //发送消息队列，让将redis数据写入数据库
		msgSender.sendMsgB("a2");
		return "新增用户成功！";
	}
}
