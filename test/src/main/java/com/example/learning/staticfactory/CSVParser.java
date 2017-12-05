package com.example.learning.staticfactory;

import java.io.File;
import java.util.List;

public class CSVParser implements Parser {
	
	public CSVParser(File file) {
		System.out.println("CSV Parser");
	}

	@Override
	public List<Records> parse() {
		System.out.println("Parsing CSV file...");
		return null;
	}

}
