package com.example.interview.basics;

import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;


public class Hacker1 {

	public Hacker1() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws Exception {
		
		testMain();
	}
	
	public static void tst() {
	}
	
	public static void testMain() throws Exception {
		List<String> list = new ArrayList<>();
		list.add("19th Oct 2015");
		list.add("25th Mar 2004");
		list.add("1st Jan 2504");
		list.add("3rd Feb 2114");
		
		String[] inArr = list.toArray(new String[list.size()]);
		System.out.println(Arrays.toString(inArr));		
		//Arrays.stream(inArr).forEach(str -> System.out.println(str));
		
		String[] outArr = test(inArr);
		
		System.out.println(Arrays.toString(outArr));
		//Arrays.stream(outArr).forEach(str -> System.out.println(str));
	}
	
	public static String[] test(String... inputArr) throws ParseException {
		List<String> list = new ArrayList<>();
		
		/*SimpleDateFormat fmt = new SimpleDateFormat("DD/Mmm/yyyy");
		SimpleDateFormat fmt1 = new SimpleDateFormat("yyyy-MM-dd");*/
		
		for (String input : inputArr) {
			
			LocalDate ldt = LocalDate.parse(input, DateTimeFormatter.ofPattern("d['st']['th']['nd']['rd'] MMM yyyy",Locale.ENGLISH));
			System.out.println(" --> " + ldt.toString());
			
			String arr[] = input.split(" ");
			
			String year = arr[2];
			String mon = arr[1];
			String dateStr =  arr[0];
			String dt = dateStr.substring(0, dateStr.length()-2);
			dt = String.format("%02d", Integer.parseInt(dt));
			
			Month mm = Month.valueOf(mon);
			
			list.add(year + "-" + mm.getMon() + "-" + dt);
		}
		
		return list.toArray(new String[list.size()]);
	}
	
	public static long power(int x, int y) throws Exception {
		if (x < 0 || y < 0) {
			throw new Exception("n or p should not be negative.");
		} else if (x == 0 || y == 0) {
			throw new Exception("n and p should not be zero.");
		}
		return (int) Math.pow(x, y);
		
		// System.out.println("" + power(-1, 0));
	}
	
	public void exceptionHandling() {
		Scanner s = new Scanner(System.in);
		int x = 0, y = 0;
		try {
			x = s.nextInt();
			y = s.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("java.util.InputMismatchException");
			System.exit(0);
		}
		try {
			int result = x / y;
			System.out.println(result);
		} catch (ArithmeticException e) {
			System.out.println(e.toString());
		}
	}

	public void test() throws IOException {
		A a = new A();
		B b = new B();
		A c = b;
	}

}

enum Month {
	Jan("01"), Feb("02"), Mar("03"),  Oct("10");
	
	private String mon;
	
	private Month(String m) {
		this.mon = m;
	}

	public String getMon() {
		return mon;
	}
}

class A {

	public A() throws IOException {
		throw new IOException("ex");
	}
}

class B extends A {
	public B() throws IOException {
		super();
	}
}

class C extends A {
	public C() throws IOException {
		super();
	}
}
