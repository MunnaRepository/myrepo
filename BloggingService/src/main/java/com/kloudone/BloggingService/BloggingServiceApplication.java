package com.kloudone.BloggingService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class BloggingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BloggingServiceApplication.class, args);
	}

}
