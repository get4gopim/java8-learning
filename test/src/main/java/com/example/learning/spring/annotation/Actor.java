package com.example.learning.spring.annotation;

public class Actor extends Cast {

	public Actor(String name) {
		super(name);
	}

	private int bodyWeight;

	public int getBodyWeight() {
		return bodyWeight;
	}

	public void setBodyWeight(int bodyWeight) {
		this.bodyWeight = bodyWeight;
	}
	
}
