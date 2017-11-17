package com.example.learning.spring;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestService {

	private static final Logger LOGGER = Logger.getLogger(TestService.class);
	
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config.xml");
		LoginService service = ctx.getBean(LoginService.class);
		boolean isAuthenticated = service.isAuthenticated("admin", "Admin123!");
		
		LOGGER.debug("isAuthenticated: " + isAuthenticated);
	}
}
