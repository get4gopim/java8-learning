package com.example.learning.java8;

import org.apache.log4j.Logger;

public class MathOperationDemo {
	
	private static final Logger LOGGER = Logger.getLogger(MathOperationDemo.class);

	public static void main(String[] args) {
		MathOperationDemo tester = new MathOperationDemo();
		
		MathOperation addition = (a, b) -> a + b;
		MathOperation sub = (a, b) -> a - b;
		MathOperation multiply = (a, b) -> a * b;
		MathOperation div = (a, b) -> a / b;
		
		LOGGER.debug("addition: " + tester.operate(5, 10, addition));
		LOGGER.debug("sub: " + tester.operate(15, 5, sub));
		LOGGER.debug("multiply: " + tester.operate(15, 3, multiply));
		LOGGER.debug("div: " + tester.operate(10, 5, div));
	}
	
	interface MathOperation {
		int operation(int a, int b);
	}
	
	private int operate(int a, int b, MathOperation mathOperation) {
		return mathOperation.operation(a, b);
	}
}
