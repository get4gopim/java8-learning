package com.example.hackerrank.datastructures;

import java.util.Scanner;
import java.util.Stack;

public class BalancedBrackets {
	
	private static int j = 100;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int a0 = 0; a0 < t; a0++) {
			String expression = in.next();
			System.out.println((isBalanced(expression)) ? "YES" : "NO");
		}

	}

	static boolean isBalanced(String expression) {
		boolean isBalanced = false;
		
		Stack<String> stack = new Stack<>();
		
		if (expression.length() % 2 != 0) return false;
		
		for (int i=0;i<expression.length();i++) {
			String s = ""+expression.charAt(i);
			
			if (s.equals("{") || s.equals("[") || s.equals("(")) {
				stack.push(s);
			}
			
			if (s.equals("}") || s.equals("]") || s.equals(")")) {
				
				if (stack.isEmpty()) return false;
				
				String opening = stack.peek();
				if (s.equals("}") && opening.equals("{")) {
					stack.pop();
				}
				
				if (s.equals("]") && opening.equals("[")) {
					stack.pop();
				}
				
				if (s.equals(")") && opening.equals("(")) {
					stack.pop();
				}
			}	
			
		}
		
		if (stack.isEmpty()) isBalanced = true;
	
		return isBalanced;
	}

}
