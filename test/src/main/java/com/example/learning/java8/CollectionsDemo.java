package com.example.learning.java8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Spliterator;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;

public class CollectionsDemo {

	private static final Logger LOGGER = Logger.getLogger(CollectionsDemo.class);
	
	public static void main(String[] args) {
		List<String> names = new ArrayList<>();
		names.add("Sansa Stark");
		names.add("Brann Stark");
		names.add("Rob Stark");
		names.add("Arya Stark");
		names.add("Nerd Stark");
		names.add("Catalyn Stark");
		
		names.stream().map(s -> s.length()).filter(len -> len > 10).collect(Collectors.toList()).forEach(System.out::println);
		int res = names.stream().map(s -> s.length()).reduce(0, (a,b) -> a+b).intValue();
		System.out.println(res);
		
	 	
		Spliterator<String> split = names.spliterator();
		System.out.println("est. size=" + split.estimateSize() + "; chara=" + split.characteristics());
		Spliterator<String> split1 = split.trySplit();
		System.out.println("est. size=" + split1.estimateSize() + "; chara=" + split1.characteristics());
		
		System.out.println("****** Initial split ******");
		split.forEachRemaining(System.out::println);
		
		System.out.println("****** Remaining split ******");
		split1.forEachRemaining(System.out::println);
		
		LOGGER.debug("Before: " + names);
		
		Collections.sort(names, (s1, s2) -> s1.compareTo(s2));
		
		LOGGER.debug("After: ");
		
		names.forEach(CollectionsDemo::print);
	}
	
	public static void print(String x) {
		LOGGER.debug(x + ", ");
	}

}

interface Service {
	
	default void add() {
		System.out.println("add");
	}
	
}
