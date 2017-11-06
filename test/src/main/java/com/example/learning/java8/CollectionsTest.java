package com.example.learning.java8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionsTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> names = new ArrayList<>();
		names.add("Sansa Stark");
		names.add("Brann Stark");
		names.add("Rob Stark");
		names.add("Arya Stark");
		names.add("Nerd Stark");
		names.add("Catalyn Stark");
		
		System.out.println("Before: " + names);
		
		Collections.sort(names, (s1, s2) -> s1.compareTo(s2));
		
		System.out.println("After: ");
		
		names.forEach(CollectionsTest::print);
	}
	
	public static void print(String x) {
		System.out.print(x + ", ");
	}

}
