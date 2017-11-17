package com.example.learning.aop;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringTestMain {
	
	public static final Logger LOGGER = Logger.getLogger(SpringTestMain.class);

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext ctx = new AnnotationConfigApplicationContext(MainConfiguration.class);
		
		
		EmployeeService empService = ctx.getBean("employeeService", EmployeeService.class);
		Employee emp = empService.findEmployeeByName("Jaime Lannister");
		
		LOGGER.debug(emp);
	}

}
