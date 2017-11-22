package com.example.interview.basics;

public class App1 {

	public static void main(String[] args) {
		MyClass1 call = new MyClass1();
		call.test();
	}
	
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
