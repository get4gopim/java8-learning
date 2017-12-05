package com.example.learning.staticfactory;

public class MainApp {

	public static void main(String[] args) {
		BatchProcessor batch = createBatchPrcessor(args[1]);
		batch.processBatch(args[0]);
	}

	private static BatchProcessor createBatchPrcessor(String format) {
		if (format.equals("text" )) {
			return new TXTBatchProcessor();
		} else if (format.equals("csv" )) {
			return new CSVBatchProcessor();
		} else if (format.equals("xml" )) {
			return new TXTBatchProcessor();
		}
		
		return null;
	}

}
