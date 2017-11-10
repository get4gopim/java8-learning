package com.example.learning.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestService {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config.xml");
		LoginService service = ctx.getBean(LoginService.class);
		boolean isAuthenticated = service.isAuthenticated("admin", "Admin123!");
		
		System.out.println("isAuthenticated: " + isAuthenticated);
	}
}
