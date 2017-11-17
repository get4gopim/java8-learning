package com.example.learning.factorypattern;

import org.apache.log4j.Logger;

public class Square implements Shape {

	private static final Logger LOGGER = Logger.getLogger(Square.class);
	
	@Override
	public void draw() {
		LOGGER.debug("Square...");

	}

}
