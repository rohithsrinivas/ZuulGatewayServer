package com.zuul.gateway;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.filters.route.ZuulFallbackProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;

@SpringBootApplication
@EnableZuulProxy
@EnableEurekaClient
@ComponentScan(basePackages = "com.zuul.*")
public class ZoolGateway2Application {

	public static void main(String[] args) {
		SpringApplication.run(ZoolGateway2Application.class, args);
	}

	// @Bean
	// public ZuulSimpleFilter simpleFilter() {
	// return new ZuulSimpleFilter();
	// }

	@Bean
	public ZuulFallbackProvider zuulFallbackProvider() {

		return new ZuulFallbackProvider() {

			@Override

			public String getRoute() {
				System.out.println("router initialized");
				return "bookingservice";

			}

			@Override

			public ClientHttpResponse fallbackResponse() {

				return new ClientHttpResponse() {

					@Override

					public HttpHeaders getHeaders() {
						System.out.println("header initialied");
						HttpHeaders headers = new HttpHeaders();
						headers.setContentType(MediaType.APPLICATION_JSON);
						return headers;

					}

					@Override

					public InputStream getBody() throws IOException {
						System.out.println("body initialized");
						return new ByteArrayInputStream("fallback".getBytes());

					}

					@Override

					public String getStatusText() throws IOException {

						return "OK";

					}

					@Override

					public HttpStatus getStatusCode() throws IOException {

						return HttpStatus.OK;

					}

					@Override

					public int getRawStatusCode() throws IOException {

						return 200;

					}

					@Override

					public void close() {

					}

				};

			}

		};

	}
}
