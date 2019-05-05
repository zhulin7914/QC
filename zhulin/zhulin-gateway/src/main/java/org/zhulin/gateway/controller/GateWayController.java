package org.zhulin.gateway.controller;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import reactor.core.publisher.Mono;

@RestController
public class GateWayController {

	@Bean
	public RouteLocator myRoutes(RouteLocatorBuilder builder) {
		// route路由的意思
		String httpUri = "http://httpbin.org:80";
		return builder.routes()
				.route(p -> p.path("/get").filters(f -> f.addRequestHeader("Hello", "World")).uri(httpUri))
				.route(p -> p.host("*.hystrix.com")
						.filters(f -> f.hystrix(config -> config.setName("mycmd").setFallbackUri("forward:/fallback")))
						.uri(httpUri))
				.build();
	}

	@RequestMapping("/fallback")
	public Mono<String> fallback() {
		return Mono.just("fallback");
	}

}
