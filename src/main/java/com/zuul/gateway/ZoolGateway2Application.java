package com.zuul.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableZuulProxy
@EnableEurekaClient
@ComponentScan(basePackages="com.zuul.*")
public class ZoolGateway2Application {

	public static void main(String[] args) {
		SpringApplication.run(ZoolGateway2Application.class, args);	
	}
	
//	@Bean
//	  public ZuulSimpleFilter simpleFilter() {
//	    return new ZuulSimpleFilter();
//	  }
}
