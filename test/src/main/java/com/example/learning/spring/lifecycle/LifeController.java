package com.example.learning.spring.lifecycle;

public class LifeController {
	
	private LifeCycleService service;

	public LifeController(LifeCycleService service) {
		this.service = service;
		System.out.println("LifeController Instantiation ...");
	}
	
	public String greetings() {
		return service.getName();
	}
	
}
