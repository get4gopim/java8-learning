package com.example.learning.commandpattern;

import org.apache.log4j.Logger;

public class Baleno implements Car {
	
	private static final Logger LOGGER = Logger.getLogger(Baleno.class);

	@Override
	public void drive() {
		LOGGER.debug("Driving Baleno...");
	}

}
