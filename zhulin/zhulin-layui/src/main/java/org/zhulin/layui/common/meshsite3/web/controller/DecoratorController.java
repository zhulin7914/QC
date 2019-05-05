package org.zhulin.layui.common.meshsite3.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 拦截请求的控制器 将请求分发到sitemesh定义的页面
 */
@Controller
@RequestMapping("/layout")
public class DecoratorController {

	@RequestMapping("main")
	public String toMain() {
		return "/layout/main";
	}

}