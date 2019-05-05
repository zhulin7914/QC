package com.layui.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequestMapping(value = "/web")
public class WebController {

	@RequestMapping("/new1")
	public String new1() {
		return "/demo/new1";
	}
	
	@RequestMapping("/lcgrpcont")
	public String showLcgrpcont() {
		return "/demo/lcgrpcont";
	}
}
