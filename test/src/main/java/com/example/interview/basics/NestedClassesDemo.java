package com.example.interview.basics;

import java.util.EnumSet;
import java.util.Set;

public class NestedClassesDemo {

	public static void main(String[] args) {
		OuterClass.StaticNestedClass nested = new OuterClass.StaticNestedClass();
		nested.test();
		OuterClass.StaticNestedClass.testStatic();
		
		OuterClass.InnerClass inner = new OuterClass().new InnerClass();
		inner.test();
		
		new OuterClass().applyStyles(EnumSet.of(OuterClass.Style.BOLD, OuterClass.Style.ITALIC));
	}

}

class OuterClass {

	int i = 10;
	static int static_i = 100;
	
	public enum Style {
		BOLD, ITALIC, UNDERLINE, HYPERLINK
	}
	
	private Style style;
	
	public void applyStyles(Set<Style> styles) {
		
	}

	static class StaticNestedClass {

		public void test() {
			System.out.println(String.format("StaticNestedClass: i = %d, static_i = %d", -2, static_i));
		}
		
		public static void testStatic() {
			System.out.println(String.format("StaticNestedClass: i = %d, static_i = %d", -2, static_i));
		}
	}

	class InnerClass {

		public void test() {
			System.out.println(String.format("InnerClass: i = %d, static_i = %d", i, static_i));
		}
	}
}
