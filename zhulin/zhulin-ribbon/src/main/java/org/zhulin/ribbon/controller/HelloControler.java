package org.zhulin.ribbon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zhulin.ribbon.service.HelloService;

@RestController
public class HelloControler {

    @Autowired
    HelloService helloService;

    @RequestMapping("/hi")
	public String home(@RequestParam(value = "name", defaultValue = "forezp") String name) {
    	System.out.println(name);
        return helloService.hiService( name );
    }
}