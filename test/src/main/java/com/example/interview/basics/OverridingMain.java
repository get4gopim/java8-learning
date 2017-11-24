package com.example.interview.basics;

import java.util.ArrayList;
import java.util.List;

public class OverridingMain {

	private static List<Vehicle> list = new ArrayList<>();
	
	public static void main(String[] args) {
		
		System.out.println("Byte.MAX_VALUE " + Byte.MIN_VALUE); // 2^7 - 1
		System.out.println("Short.MAX_VALUE " + Short.MAX_VALUE); // 2^15 - 1
		System.out.println("Integer.MAX_VALUE " + Integer.MAX_VALUE); // 2^31 - 1
		System.out.println("Long.MAX_VALUE " + Long.MAX_VALUE); // 2^63 - 1
		System.out.println("Float.MAX_VALUE " + Float.MAX_VALUE);
		System.out.println("Double.MAX_VALUE " + Double.MAX_VALUE);
		
		Vehicle v = new SUVCar();
		v.drive();
		
		FourWheeler f = new FourWheeler();
		
		list.add(new FourWheeler());
		list.add(new SUVCar());
		list.add(new Vehicle());
		
		System.out.println("LIST: " + list);
		
		Vehicle addedElement = addToList(list);
		
		System.out.println("LIST: " + list);
		
		removeFromList(list, addedElement);
		
		System.out.println("LIST: " + list);
	}
	
	public static Vehicle addToList(List<? super Vehicle> vehicles) {
		Vehicle v = new SUVCar();
		vehicles.add(v);
		return v;
	}
	
	public static void removeFromList(List<? extends Vehicle> vehicles, Vehicle removeElement) {
		vehicles.remove(removeElement);
	}
}
