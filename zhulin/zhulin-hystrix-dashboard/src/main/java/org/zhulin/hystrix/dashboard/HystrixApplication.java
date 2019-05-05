package org.zhulin.hystrix.dashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication
@EnableEurekaClient
//开启断路器
@EnableHystrix 
public class HystrixApplication {

    public static void main(String[] args) {
    	SpringApplication.run( HystrixApplication.class, args );
    }
    
}
