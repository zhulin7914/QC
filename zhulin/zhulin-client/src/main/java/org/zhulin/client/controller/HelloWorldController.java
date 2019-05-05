package org.zhulin.client.controller;

import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * json 接口开发 spring boot只需要类添加 @RestController 即可 默认类中的方法都会以json的格式返回
 */
@RestController
// 表示该controller类下所有的方法都公用的一级上下文根
@RequestMapping(value = "/springboot")
public class HelloWorldController {

	@Value("${server.port}")
	String port;

	@RequestMapping("/hi")
	public String home(@RequestParam(value = "name", defaultValue = "forezp") String name) {
		return "hi " + name + " ,i am from port:" + port;
	}

	// 这里使用@RequestMapping注解表示该方法对应的二级上下文路径
	@RequestMapping(value = "/getUserByGet", method = RequestMethod.GET)
	// @RequestParam，该注解可以通过value指定入参
	String getUserByGet(@RequestParam(value = "userName") String userName) {
		return "Hello " + userName;
	}

	// 通过RequestMethod.POST表示请求需要时POST方式
	@RequestMapping(value = "/getUserByPost", method = RequestMethod.POST)
	String getUserByPost(@RequestParam(value = "userName") String userName) {
		return "Hello " + userName;
	}

	// 在入参设置@RequestBody注解表示接收整个报文体，这里主要用在接收整个POST请求中的json报文体，
	// 目前主流的请求报文也都是JSON格式了，使用该注解就能够获取整个JSON报文体作为入参，使用JSON解析工具解析后获取具体参数
	@RequestMapping(value = "/getUserByJson", method = RequestMethod.POST)
	String getUserByJson(@RequestBody String data) {
		return "Json is " + data;
	}

	@RequestMapping("/hello")
	public String index() {
		return "Hello World";
	}

	// Spring Redis Session测试
	@RequestMapping("/uid")
	String uid(HttpSession session) {
		UUID uid = (UUID) session.getAttribute("uid");
		if (uid == null) {
			uid = UUID.randomUUID();
		}
		session.setAttribute("uid", uid);
		return session.getId();
	}
}
