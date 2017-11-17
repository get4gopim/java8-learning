package com.example.learning.commandpattern;

import org.apache.log4j.Logger;

public class Creta implements Car {

	private static final Logger LOGGER = Logger.getLogger(Creta.class);
	
	@Override
	public void drive() {
		LOGGER.debug("Driving Creta...");
	}

}
