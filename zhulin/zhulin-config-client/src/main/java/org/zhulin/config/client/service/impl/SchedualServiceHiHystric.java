package org.zhulin.config.client.service.impl;

import org.zhulin.config.client.service.SchedualServiceHi;
import org.springframework.stereotype.Component;

@Component
public class SchedualServiceHiHystric implements SchedualServiceHi {

	@Override
	public String sayHiFromClientOne(String name) {
		return "sorry " + name;
	}

}
