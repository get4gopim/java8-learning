package com.example.interview.basics;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;


public class HackerRank01 {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("29th Oct 2017");
		list.add("2nd Dec 2097");
		
		String[] inArr = list.toArray(new String[list.size()]);
		
		String[] outArr = solution(inArr);
		
		//list.stream().mapToInt(str -> str.length()).forEach(System.out::println);
		
		//list.stream().map(str -> str.substring(0, 2)).forEach(System.out::println);
		
		System.out.println(Arrays.toString(inArr));
		System.out.println(Arrays.toString(outArr));
	}
	
	public static String[] solution(final String... inArr) {
		List<String> list = new ArrayList<>();
		
		for (String input : inArr) {
			LocalDate ldt = LocalDate.parse(input, DateTimeFormatter.ofPattern("d['st']['nd']['rd']['th'] MMM yyyy", Locale.ENGLISH));
			System.out.println("-> " + ldt.toString());
			
			String arr[] = input.split(" ");
			String dateStr = arr[0];
			String monStr = arr[1];
			String yearStr = arr[2];
			
			Month mon = Month.valueOf(monStr);
			String dt = dateStr.substring(0, dateStr.length()-2);
			dt = String.format("%02d", Integer.parseInt(dt) );
			
			String outStr = yearStr + "-" + mon.getMon() + "-" + dt;
			list.add(outStr);
		}
		
		return list.toArray(new String[list.size()]);
	}

}

enum Month {
	Jan("1"), Feb("2"), Mar("3"), Apr("4"), Oct("10"), Dec("12");
	
	private String mon;
	
	private Month(String m) {
		this.mon = m;
	}

	public String getMon() {
		return this.mon;
	}
}
