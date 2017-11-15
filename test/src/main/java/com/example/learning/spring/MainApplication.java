package com.example.learning.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		PhoneBook book = ctx.getBean("phoneBook", PhoneBook.class);
		book.setName("Tyrion Lannister");
		book.setPhoneNumber("+01 812 391 212 29");
		
		System.out.println(book.toString());			
	}

}
