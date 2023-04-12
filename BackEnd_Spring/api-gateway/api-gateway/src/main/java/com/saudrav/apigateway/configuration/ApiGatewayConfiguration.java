package com.saudrav.apigateway.configuration;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
//public class ApiGatewayConfiguration {
//	
//	@Bean
//	public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {
//		return builder.routes()
//				.route("CURRENCY-EXCHANGE", p -> p.path("/currency-exchange/**")
////						.filters(f -> f.circuitBreaker(
////										c -> c.setName("CURRENCY-EXCHANGE")
////										//.setFallbackUri("forward:/currencyExchangeServiceFallBack")
////										)
////								)
//						.uri("lb://CURRENCY-EXCHANGE"))
//				
//				.route(p -> p.path("/currency-conversion/**")
//						.uri("lb://CURRENCY-CONVERSION"))
//				
//				.route(p -> p.path("/currency-conversion-new/**")
//						.filters(f -> f.rewritePath(
//								"/currency-conversion-new/(?<segment>.*)", 
//								"/currency-conversion/${segment}"))
//						.uri("lb://currency-conversion"))
//				
//				.route(p -> p
//						.path("/get")
//						.filters(f -> f
//								.addRequestHeader("MyHeader", "MyURI")
//								.addRequestParameter("Param", "MyValue"))
//						.uri("http://httpbin.org:80"))
//				.build();
//	}
//}
