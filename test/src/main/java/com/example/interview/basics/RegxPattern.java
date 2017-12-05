package com.example.interview.basics;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegxPattern {

	public static void main(String[] args) {
		final String input = "29th Oct 2018";
		
		String strPattern = "(\\D)(\\s)(\\D)";
		Pattern pattern = Pattern.compile(strPattern);
		Matcher matcher = pattern.matcher(input);
		System.out.println("ss=" + matcher.replaceAll("") );
		
		System.out.println("re,lasd=" +input.replaceAll(strPattern, "$3") );
		
		while ( matcher.find()) {
			System.out.print("Start index: " + matcher.start());
            System.out.print(" End index: " + matcher.end() + " ");
            System.out.println(input.substring(matcher.start(), matcher.end()) );
		}
		

	}

}
