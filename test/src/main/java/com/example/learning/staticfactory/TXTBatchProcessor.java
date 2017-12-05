package com.example.learning.staticfactory;

import java.io.File;

public class TXTBatchProcessor extends BatchProcessor {

	@Override
	public Parser createParser(File file) {
		return new TXTParser(file);
	}

}
