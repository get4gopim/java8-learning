package com.example.learning.spring;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApplication {
	
	private static final Logger LOGGER = Logger.getLogger(MainApplication.class);

	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		PhoneBook book = ctx.getBean("phoneBook", PhoneBook.class);
		book.setName("Tyrion Lannister");
		book.setPhoneNumber("+01 812 391 212 29");
		
		LOGGER.debug(book.toString());			
	}

}
