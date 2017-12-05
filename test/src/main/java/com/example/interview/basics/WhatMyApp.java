package com.example.interview.basics;

import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class WhatMyApp {

	public static void main(String[] args) {
		List<String> list = new CopyOnWriteArrayList<>();
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");

		ListIterator<String> itr = list.listIterator();
		while (itr.hasNext()) {
			String s = itr.next();
			System.out.println(s);
			list.remove("1");
		}
		
		itr = list.listIterator();
		while (itr.hasNext()) {
			System.out.println(" -- " + itr.next());
		}
	}

}
