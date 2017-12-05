package com.example.learning.staticfactory;

import java.io.File;
import java.util.List;

public class TXTParser implements Parser {
	
	public TXTParser(File file) {
		System.out.println("TEXT Parser");
	}

	@Override
	public List<Records> parse() {
		System.out.println("Parsing TEXT file...");
		return null;
	}

}
