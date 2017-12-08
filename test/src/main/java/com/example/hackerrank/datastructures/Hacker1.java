package com.example.hackerrank.datastructures;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.PriorityQueue;

public class Hacker1 {

	public static void main(String[] args) {
		// System.out.println("test");
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		queue.add(2);
		queue.add(22);
		queue.add(10);
		queue.add(42);
		
		while (queue.isEmpty() == false) 
			System.out.println(queue.remove());
		
		StringBuilder s1 = new StringBuilder("Java");
		String s2 = "Love";
		s1.append(s2);
		s1.substring(4);
		System.out.println(s1.indexOf(s2));
		
		int num = 0b1010_1011_0111;
		System.out.println(num);
		
		A o = new A();
		if (o  instanceof C)  System.out.println("A");
		else if (o  instanceof B)  System.out.println("B");
		else if (o  instanceof C)  System.out.println("C");
		
		
	}
	
		

}


class C {
	
}
class B extends C {
	
}
class A extends B {
	
}