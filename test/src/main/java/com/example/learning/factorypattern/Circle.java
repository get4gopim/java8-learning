package com.example.learning.factorypattern;

import org.apache.log4j.Logger;

public class Circle implements Shape {

	private static final Logger LOGGER = Logger.getLogger(Circle.class);
	
	@Override
	public void draw() {
		LOGGER.debug("Circle...");
	}

}
