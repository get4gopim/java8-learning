package com.example.learning.commandpattern;

import java.util.EnumMap;

public class CommandPatternDemo {
	
	private static EnumMap<CarType, Car> carHandler = new EnumMap<> (CarType.class);
	
	static {
		carHandler.put(CarType.BALENO, new Baleno());
		carHandler.put(CarType.CRETA, new Creta());
		carHandler.put(CarType.ECOSPORT, new EcoSport());
	}

	public static void main(String[] args) {
		CommandPatternDemo test = new CommandPatternDemo();
		
		test.getCar("EcoSport").drive();
		test.getCar(CarType.CRETA).drive();
	}
	
	public Car getCar(String carType) {
		if (carType.equals("EcoSport")) {
			return new EcoSport();
		} else if (carType.equals("Baleno")) {
			return new Baleno();
		} else if (carType.equals("Creta")) {
			return new Creta();
		} else {
			return null;
		}
	}
	
	public Car getCar(CarType carType) {
		return carHandler.get(carType);
	}

}
