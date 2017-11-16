package com.bootexample.customer;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
	
	private static final Logger LOGGER = Logger.getLogger(Application.class);

	public static void main(String[] args) {
		LOGGER.info("Customer Rest Service Started...");
		
		SpringApplication.run(Application.class, args);
	}

}
