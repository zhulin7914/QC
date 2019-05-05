package org.zhulin.ribbon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.client.RestTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication
@EnableEurekaClient
//@EnableEurekaClient默认实现了@EnableDiscoveryClient注解
@EnableHystrix  //开启Hystrix断路器
public class EurekaClientApplication {
	public static void main(String[] args) {
		SpringApplication.run(EurekaClientApplication.class, args);
	}
	
	//这里就是创建一个负载均衡的RestTemplate Bean
	@Bean
	@LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
}