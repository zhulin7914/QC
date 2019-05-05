package org.zhulin.config.client.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.zhulin.config.client.service.impl.SchedualServiceHiHystric;

//@FeignClient 用于开启负载均衡
//fallback用于开启Hystrix断路器的指向结果
@FeignClient(value = "config-server",fallback = SchedualServiceHiHystric.class)
public interface SchedualServiceHi {
	@RequestMapping(value = "/configserver/hi",method = RequestMethod.GET)
    String sayHiFromClientOne(@RequestParam(value = "name") String name);
}
