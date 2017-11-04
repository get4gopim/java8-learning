package com.example.learning.factorypattern;

public class MainTest {

	public static void main(String[] args) {
		ShapeFactory.getShape("CIRCLE").draw();
		ShapeFactory.getShape("SQUARE").draw();
	}

}
