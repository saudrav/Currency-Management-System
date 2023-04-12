package com.saudrav.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//import io.github.resilience4j.circuitbreaker.EnableCircuitBreaker;

@SpringBootApplication
public class ApiGatewayApiRoutingApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApiRoutingApplication.class, args);
	}

}
