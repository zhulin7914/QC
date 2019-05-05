package org.zhulin.config.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.zhulin.config.client.service.SchedualServiceHi;

@RestController
@RefreshScope
public class HelloController {
	
	@Value("${foo}")
	String foo;
		
	@Autowired
    SchedualServiceHi schedualServiceHi;

	@RequestMapping("/hi")
    public String sayHi(@RequestParam String name) {
    	StringBuffer sBuffer = new StringBuffer("");
        sBuffer.append(schedualServiceHi.sayHiFromClientOne( name ));
        sBuffer.append(foo);
        return sBuffer.toString();
    }

}
