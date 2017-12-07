package com.example.hackerrank.datastructures;

import java.util.Scanner;

public class Fibonacci {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();
        System.out.println(fibonacci(n));

	}
	
	public static int fibonacci(int n) {
		System.out.println(n);
		
		if (n == 0) return 0;
		else if (n == 1) return 1;
		else  {
			return fibonacci(n - 1) + fibonacci(n - 2);
		}
    }

}
