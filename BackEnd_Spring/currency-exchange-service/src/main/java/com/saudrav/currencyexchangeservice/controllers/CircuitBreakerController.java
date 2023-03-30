package com.saudrav.currencyexchangeservice.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.RetryConfig;
import io.github.resilience4j.retry.annotation.Retry;

@RestController
public class CircuitBreakerController {

	private Logger logger = LoggerFactory.getLogger(CircuitBreakerController.class);


	@GetMapping("/sample-api")
	@Retry(name = "sample-api", fallbackMethod = "hardcodedResponse")
	public String sampleApi() {
		logger.info("Sample api call received");
		ResponseEntity<String> forEntity = new RestTemplate().getForEntity("http://localhost:8080/some-dummy-url", 
					String.class);
		return forEntity.getBody();
		//return "sample-api";
	}

	@GetMapping("/sample-api-2")
	@CircuitBreaker(name = "sample-api-2", fallbackMethod = "hardcodedResponse")
	public String sampleApi2() {
		logger.info("Sample api - 2 call received");
		ResponseEntity<String> forEntity = new RestTemplate().getForEntity("http://localhost:8080/some-dummy-url", 
					String.class);
		return forEntity.getBody();
		//return "sample-api-2";
	}
	
	
	@GetMapping("/sample-api-3")
	@RateLimiter(name="sample-api-3")
	public String sampleApi3() {
		logger.info("Sample api - 3 call received");
		return "sample-api-3";
	}
	
	
	@GetMapping("/sample-api-4")
	@Bulkhead(name="sample-api-4")
	public String sampleApi4() {
		logger.info("Sample api - 4 call received");
		return "sample-api-4";
	}
	
	public String hardcodedResponse(Exception ex) {
		return "fallback-response";
	}

}
