package com.example.interview.basics;

import java.util.function.Function;

public class StringMainApp {

	public static void main(String[] args) {
		MyClass1 call = new MyClass1();
		call.test();
		
		Object obj = null;
		method(null);
		method(obj);
	}
	
	public static void method(Object obj) {
		Function<Integer, Integer> squareRoot = x -> x * x;
		
		System.out.println("OBJ :: " + squareRoot.apply(5));
		
	}
	
	public static void method(String obj) {
		System.out.println("STR");
	}
	
	/*public static void method(MyClass1 obj) {
		System.out.println("MyClass1");
	}*/
	
}

class MyClass1 {
	
	private String s1 = "Hello";
	
	public void test() {
		String s2 = new String("Hello");
		String s3 = s2.intern();
		String s4 = s2;
		
		System.out.println("s1 == s2 = " + (s1 == s2) );
		System.out.println("s1 == s3 = " + (s1 == s3) );
		System.out.println("s1 == s4 = " + (s1 == s4) );
		System.out.println("s3 == s4 = " + (s3 == s4) );
		System.out.println("s4 == s2 = " + (s4 == s2) );
	}
}
