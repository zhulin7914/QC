package org.zhulin.feign.service.impl;

import org.zhulin.feign.service.SchedualServiceHi;
import org.springframework.stereotype.Component;

@Component
public class SchedualServiceHiHystric implements SchedualServiceHi {

	@Override
	public String sayHiFromClientOne(String name) {
		return "sorry " + name;
	}

}
