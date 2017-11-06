package com.example.learning.builderpattern;

public class BuilderTest {

	public static void main(String[] args) {
		Computer comp = new Computer.ComputerBuilder(128, 2).setBluetoothEnabled(true).build();
		System.out.println(comp);
	}

}
