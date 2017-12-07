package com.example.hackerrank.datastructures;

import java.util.HashMap;
import java.util.Scanner;

public class Staircase {

	private static HashMap<Integer, Integer> cache = new HashMap<>();

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int testcases = scan.nextInt();
		cache.put(0, 1); // base case
		cache.put(1, 1);
		cache.put(2, 2);
		while (testcases-- > 0) {
			int n = scan.nextInt();
			System.out.println(staircase(n));
		}
		scan.close();
	}

	private static int staircase(int n) {
		if (n < 0) {
			return 0;
		}
		if (cache.containsKey(n)) {
			return cache.get(n);
		}
		int ways = staircase(n - 1) + staircase(n - 2) + staircase(n - 3);
		
		System.out.println(String.format("n=%d, ways=%d", n, ways));
		
		cache.put(n, ways);
		return ways;
	}

}
