package org.zhulin.zipkin.hi.controller;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HiController {

	private static final Logger LOG = Logger.getLogger(HiController.class.getName());

	@Autowired
	RestTemplate restTemplate;

	@RequestMapping("/hi")
	public String callHome() {
		LOG.log(Level.INFO, "calling trace ripkin-hi  ");
		return restTemplate.getForObject("http://localhost:9101/miya", String.class);
	}

	@RequestMapping("/info")
	public String info() {
		LOG.log(Level.INFO, "calling trace ripkin-hi ");
		return "i'm service-hi";
	}
}
