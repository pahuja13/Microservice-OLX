package com.zensar.olxadvertisesservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.beans.BeanProperty;

@SpringBootApplication
public class OlxadvertisesServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OlxadvertisesServiceApplication.class, args);
	}

	@Bean
	@LoadBalanced
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}

}
