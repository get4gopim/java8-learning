package com.bootexample.customer;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient
@ComponentScan(basePackages = {"com.bootexample.customer"})
public class Application {
	
	private static final Logger LOGGER = Logger.getLogger(Application.class);

	public static void main(String[] args) {
		LOGGER.info("Customer Rest Service Started...");
		
		SpringApplication.run(Application.class, args);
	}
}
