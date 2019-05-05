package org.zhulin.config.server.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * json 接口开发 spring boot只需要类添加 @RestController 即可 默认类中的方法都会以json的格式返回
 */
@RestController
// 表示该controller类下所有的方法都公用的一级上下文根
@RequestMapping(value = "/configserver")
public class HelloWorldController {

	@Value("${server.port}")
	String port;

	@RequestMapping("/hi")
	public String home(@RequestParam(value = "name", defaultValue = "forezp") String name) {
		return "hi " + name + " ,i am from port:" + port;
	}

}
