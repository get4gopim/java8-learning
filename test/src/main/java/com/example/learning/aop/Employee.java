package com.example.learning.aop;

public class Employee {

	private String name;

	public String getName() {
		return name;
	}

	public Employee setName(String name) {
		this.name = name;
		return this;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + "]";
	}
	
	
}
