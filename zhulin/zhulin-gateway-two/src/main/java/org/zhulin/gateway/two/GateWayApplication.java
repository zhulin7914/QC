package org.zhulin.gateway.two;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication
@EnableEurekaClient
@EnableHystrix  //开启Hystrix断路器
public class GateWayApplication {
	public static void main(String[] args) {
		SpringApplication.run(GateWayApplication.class, args);
	}
}