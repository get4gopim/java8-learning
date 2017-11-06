package com.example.learning.java8;

public class MathOperationTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MathOperationTest tester = new MathOperationTest();
		
		MathOperation addition = (a, b) -> a + b;
		MathOperation sub = (a, b) -> a - b;
		MathOperation multiply = (a, b) -> a * b;
		MathOperation div = (a, b) -> a / b;
		
		System.out.println("addition: " + tester.operate(5, 10, addition));
		System.out.println("sub: " + tester.operate(15, 5, sub));
		System.out.println("multiply: " + tester.operate(15, 3, multiply));
		System.out.println("div: " + tester.operate(10, 5, div));
	}
	
	interface MathOperation {
		int operation(int a, int b);
	}
	
	private int operate(int a, int b, MathOperation mathOperation) {
		return mathOperation.operation(a, b);
	}
}
