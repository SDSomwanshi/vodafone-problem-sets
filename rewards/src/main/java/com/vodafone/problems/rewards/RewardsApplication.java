package com.vodafone.problems.rewards;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class RewardsApplication {

	public static void main(String[] args) {
		SpringApplication.run(RewardsApplication.class, args);
	}
	
	@Bean
    @Primary
	public RestTemplate standardRestTemplate() {
		return new RestTemplate();
	}
}
