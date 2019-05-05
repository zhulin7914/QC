package org.zhulin.ribbon.service;

import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class HelloService {

	@Autowired
	RestTemplate restTemplate;

	@HystrixCommand(fallbackMethod = "hiError")  //断路器的功能
	public String hiService(String name) {
		System.out.println("http://FILESERVER-01/springboot/hi?name=" + name);
		return restTemplate.getForObject("http://FILESERVER-01/springboot/hi?name=" + name, String.class);
	}

	public String hiError(String name) {
		return "hi," + name + ",sorry,error!";
	}

}
