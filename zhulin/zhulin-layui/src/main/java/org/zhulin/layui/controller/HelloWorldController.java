package org.zhulin.layui.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

@Controller
// 表示该controller类下所有的方法都公用的一级上下文根
@RequestMapping(value = "/layui")
public class HelloWorldController {

	private static final Logger log = LoggerFactory.getLogger(HelloWorldController.class);

	@Value("${userName}")
    private String userName;

    @Value("${bookTitle}")
    private String bookTitle;
    
    //静态页面的return默认是跳转到/static/index.html，当在pom.xml中引入了thymeleaf组件，动态跳转会覆盖默认的静态跳转，
    //默认就会跳转到/templates/index.html，注意看两者return代码也有区别，动态没有html后缀。
    
    //如果用了静态模板你还想返回static中的页面，那么就要用重定向：
    //如果在使用动态页面时还想跳转到/static/index.html，可以使用重定向return "redirect:/index.html"。
    @RequestMapping("/hi")
    public String sayHi() {
        return "redirect:/hello.html"; 
    }
    
    @RequestMapping("/hello")
    public ModelAndView sayHello() {
        // 加入一个属性，用来在模板中读取
    	ModelAndView modelAndView = new ModelAndView();
    	modelAndView.setViewName("hello");//跳转的页面
        modelAndView.addObject("name", userName);
        modelAndView.addObject("bookTitle", bookTitle);
        log.info("userName:   "+userName+"    bookTitle: "+bookTitle);
        return modelAndView;
    }
    
    @RequestMapping("/hello2")
    public ModelAndView sayHello2() {
        // 加入一个属性，用来在模板中读取
    	ModelAndView modelAndView = new ModelAndView();
    	modelAndView.setViewName("hello2");//跳转的页面
        modelAndView.addObject("name", userName);
        modelAndView.addObject("bookTitle", bookTitle);
        log.info("userName:   "+userName+"    bookTitle: "+bookTitle);
        return modelAndView;
    }
    
	@RequestMapping("/home")
	public String home() {
		return "home";
	}
	
	@RequestMapping("/new1")
	public String new1() {
		return "/demo/new1";
	}
}
