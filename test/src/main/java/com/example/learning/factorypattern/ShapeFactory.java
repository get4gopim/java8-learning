package com.example.learning.factorypattern;

public class ShapeFactory {
	
	private ShapeFactory() {
		
	}
	
	public static Shape getShape(String shape) {
		if (shape.equals("CIRCLE")) {
			return new Circle();
		} else if (shape.equals("SQUARE")) {
			return new Square();
		}
		return null;
	}

}
