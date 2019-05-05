package org.zhulin.apollo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zhulin.apollo.common.apollo.TestJavaConfigBean;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class TestController {

	  @Autowired
	  TestJavaConfigBean testJavaConfigBean;

	  @RequestMapping("/index1")
	  public String hello1(){
	    return testJavaConfigBean.getTimeout()+"";
	  }
}
