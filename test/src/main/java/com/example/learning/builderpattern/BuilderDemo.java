package com.example.learning.builderpattern;

import org.apache.log4j.Logger;

public class BuilderDemo {

	private static final Logger LOGGER = Logger.getLogger(BuilderDemo.class);
	
	public static void main(String[] args) {
		Computer comp = new Computer.ComputerBuilder(128, 2).setBluetoothEnabled(true).build();
		LOGGER.debug(comp);
		
		Camera camera = new Camera.Builder(200, 2.8f).setIso(100).build();
		LOGGER.debug(camera);
	}

}
