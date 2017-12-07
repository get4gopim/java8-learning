package com.example.hackerrank.datastructures;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FibonacciCache {
	
	static Map<Integer, Integer> cache = new HashMap<>();

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();
        
        cache.put(0, 0);
        cache.put(1, 1);
        cache.put(2, 1);
        cache.put(3, 2);
        System.out.println(fibonacci(n));
	}
	
	public static int fibonacci(int n) {
		if (n < 0) return 0;
		
		if (cache.containsKey(n)) {
			return cache.get(n);
		}
		
		int fib = fibonacci(n-1) + fibonacci(n-2);
		
		System.out.println(String.format("fib(%d) = %d", n, fib));
		cache.put(n, fib);
		
		return fib;
	}

}
