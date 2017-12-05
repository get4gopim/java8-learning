package com.example.learning.staticfactory;

import java.io.File;
import java.util.List;

public abstract class BatchProcessor {
	
	public void processBatch(String filename) {
		File file = opneFile(filename);
		Parser parser = createParser(file);
		List<Records> records = parser.parse();
		processRecords(records);
		writeSummary();
		closeFile(file);
	}

	public abstract Parser createParser(File file);
	
	private void closeFile(File file) {
		System.out.println("Closing file.");		
	}

	private void writeSummary() {
		System.out.println("Wrote batch summary - 0 files.");
	}

	private void processRecords(List<Records> records) {
		System.out.println("Processing each records... db.calls, etc.,");
	}
	
	private File opneFile(String file) {
		System.out.println("Opening file " + file);
		return null;
	}
}
