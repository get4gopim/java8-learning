package com.example.learning.java8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
		
		LOGGER.debug("Before: " + names);
		
		Collections.sort(names, (s1, s2) -> s1.compareTo(s2));
		
		LOGGER.debug("After: ");
		
		names.forEach(CollectionsDemo::print);
	}
	
	public static void print(String x) {
		LOGGER.debug(x + ", ");
	}

}
