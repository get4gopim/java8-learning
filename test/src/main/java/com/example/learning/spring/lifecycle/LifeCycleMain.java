package com.example.learning.spring.lifecycle;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LifeCycleMain {

	public LifeCycleMain() {
		System.out.println("Step 1: Read XML file");
		try (ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config-life.xml");) {

			LifeController controller = ctx.getBean("lifeController", LifeController.class);
			String output = controller.greetings();
			System.out.println(output);
		} finally {
			System.out.println("LifeCycle ends.");
		}
	}

	public static void main(String... args) {
		new LifeCycleMain();
	}

}
