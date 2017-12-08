package com.example.hackerrank.datastructures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class FindRunningMeadian {

	public static void main1(String[] args) {
		Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        
        double[] res = new double[n];
        int j = 0;        
        
        for(int a_i=0; a_i < n; a_i++) {
            a[a_i] = in.nextInt();
            
            List<Integer> list = new ArrayList<>();
        	for (int k=0;k<=a_i;k++) {        		
        		list.add(a[k]);        		
        	}        	
            
            Collections.sort(list);
            
            int x = list.size() / 2;
        	if (x == 0 || list.size() % 2 != 0) {
        		res[j] = list.get(x);
        	} else if (list.size() % 2 == 0) {        		
        		res[j] = ((double) list.get(x-1) + list.get(x)) / 2;
        	}
        	j++;
        }        
        
        Arrays.stream(res).forEach(System.out::println);
        
        in.close();
	}
	
	public static void main2(String[] args) {
		Scanner sc = new Scanner(System.in);

		PriorityQueue<Integer> lowers = new PriorityQueue<Integer>(Comparator.reverseOrder());
		PriorityQueue<Integer> uppers = new PriorityQueue<Integer>();

		int n = sc.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();			
		}
		
		for (int i = 0; i < n; i++) {
			int ai = a[i];
			
			if (!lowers.isEmpty() && ai <= lowers.peek()) {
				lowers.offer(ai);
			} else {
				uppers.offer(ai);
			}

			while (lowers.size() > uppers.size()) {
				uppers.offer(lowers.poll());
			}
			while (uppers.size() - lowers.size() > 1) {
				lowers.offer(uppers.poll());
			}

			double median;
			if (lowers.size() == uppers.size()) {
				median = (lowers.peek() + uppers.peek()) / 2.0;
			} else {
				median = uppers.peek();
			}
			System.out.printf("%.1f\n", median);
		}

		sc.close();
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();			
		}
		sc.close();
		
		PriorityQueue<Integer> lowers = new PriorityQueue<Integer>(Collections.reverseOrder());
		PriorityQueue<Integer> uppers = new PriorityQueue<Integer>();
		
		
		double[] medians = new double[n];
		
		for (int i = 0; i < n; i++) {
			addNumber(a[i], lowers, uppers);
			rebalance(lowers, uppers);
			medians[i] = getMedian(lowers, uppers);
			
			System.out.printf("%.1f\n", medians[i]);
		}		
	}

	private static double getMedian(PriorityQueue<Integer> lowers, PriorityQueue<Integer> uppers) {
		PriorityQueue<Integer> biggerHeap = lowers.size() > uppers.size() ? lowers : uppers;
		PriorityQueue<Integer> smallerHeap = lowers.size() < uppers.size() ? lowers : uppers;
		
		if (biggerHeap.size() == smallerHeap.size()) {
			return ((double) biggerHeap.peek() + smallerHeap.peek()) / 2;
		} else {
			return biggerHeap.peek();
		}
	}

	private static void rebalance(PriorityQueue<Integer> lowers, PriorityQueue<Integer> uppers) {
		PriorityQueue<Integer> biggerHeap = lowers.size() > uppers.size() ? lowers : uppers;
		PriorityQueue<Integer> smallerHeap = lowers.size() < uppers.size() ? lowers : uppers;
		
		if (biggerHeap.size() - smallerHeap.size() >= 2) {
			smallerHeap.add(biggerHeap.poll());
		}
	}

	private static void addNumber(int number, PriorityQueue<Integer> lowers, PriorityQueue<Integer> uppers) {
		if (lowers.size() == 0 || number < lowers.peek()) {
			lowers.add(number);
		} else {
			uppers.add(number);
		}
	}

}
