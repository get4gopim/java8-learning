package com.example.learning.spring.annotation;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Actress extends Cast {

	public Actress(String name) {
		super(name);
		System.out.println("Actress initialized::" + name);
	}

	private int waist;

	public int getWaist() {
		return waist;
	}

	public void setWaist(int waist) {
		this.waist = waist;
	}
	
	@PostConstruct
	public void afterConstruct() {
		System.out.println("@PostConstruct ..." + this.getName());
	}
	
	@PreDestroy
	public void beforeDestroy() {
		System.out.println("@PreDestroy ..." + this.getName());
	}

}
