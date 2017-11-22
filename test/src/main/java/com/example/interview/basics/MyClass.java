package com.example.interview.basics;

public class MyClass {
	
	public static int count = 0;
	
	private String name;
	
	public MyClass() {
		count++;
	}
	
	@Override
	public String toString() {
		return String.format("Current Object Name: %s", name);
	}
	
}
