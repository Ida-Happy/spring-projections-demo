package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.data.projection.SpelAwareProxyProjectionFactory;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class SpringProjectionsDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringProjectionsDemoApplication.class, args);
	}


	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder) {
		return restTemplateBuilder.build();
	}

	@Bean
	public SpelAwareProxyProjectionFactory projectionFactory() {
		return new SpelAwareProxyProjectionFactory();
	}

}
