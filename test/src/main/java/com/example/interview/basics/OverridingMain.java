package com.example.interview.basics;

import java.util.ArrayList;
import java.util.List;

public class OverridingMain {

	private static List<Vehicle> list = new ArrayList<>();
	
	public static void main(String[] args) {
		Vehicle v = new SUVCar();
		v.drive();
		
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
