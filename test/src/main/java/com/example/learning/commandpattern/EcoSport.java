package com.example.learning.commandpattern;

import org.apache.log4j.Logger;

public class EcoSport implements Car {

	private static final Logger LOGGER = Logger.getLogger(EcoSport.class);
	
	@Override
	public void drive() {
		LOGGER.debug("Driving EcoSport...");
	}

}
