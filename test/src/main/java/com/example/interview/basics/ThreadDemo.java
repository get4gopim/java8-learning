package com.example.interview.basics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ThreadDemo {
	
	static List<Integer> list1;
	
	static {
		list1 = new ArrayList<Integer>();
		for (int i=1;i<1000;i++) list1.add(i);
	}

	public ThreadDemo() {
	}

	public static void main(String[] args) throws InterruptedException {
		Thread1 my1 = new Thread1(list1);
		Thread1 my2 = new Thread1(Arrays.asList(11, 21, 31, 41, 51, 61, 71, 81 ,91));
		
		Thread t1 = new Thread(my1);
		Thread t2 = new Thread(my2);
		
		t1.start();
		//t1.join();
		t2.start();
		
		t2.join();
		
		
		my1.getMyValue();
		my2.getMyValue();
	}

}

class Thread1 implements Runnable {
	
	private volatile Integer myValue;
	
	private final List<Integer> list;
	
	public Thread1(List<Integer> list) {
		myValue = -1;
		this.list = list;
	}

	@Override
	public void run() {
		//this.list.forEach(System.out::println);
		myValue = (int) this.list.stream().mapToInt(x -> x.intValue()).sum();
		//list.stream().collect(Collectors.summingInt(Integer::intValue));
	}
	
	public void getMyValue() {
		System.out.println(list.size() + " : = " + myValue);
	}
	
}

class Thread2 implements Runnable {

	@Override
	public void run() {
		Arrays.asList(11, 21, 31, 41, 51, 61, 71, 81 ,91).forEach(System.out::println);
	}
	
}
