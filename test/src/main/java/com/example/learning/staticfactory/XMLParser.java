package com.example.learning.staticfactory;

import java.io.File;
import java.util.List;

public class XMLParser implements Parser {
	
	public XMLParser(File file) {
		System.out.println("XML Parser");
	}

	@Override
	public List<Records> parse() {
		System.out.println("Parsing XML file...");
		return null;
	}

}
