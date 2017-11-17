package com.example.interview.volatiletest;

import org.apache.log4j.Logger;

public class VolatileDemo {

	private static final Logger LOGGER = Logger.getLogger(VolatileDemo.class);

	private static volatile int myCounter = 0;

	public static void main(String[] args) {
		new ChangeListener().start();
		new ChangeMaker().start();
	}

	static class ChangeListener extends Thread {
		@Override
		public void run() {
			int localValue = myCounter;
			while (localValue < 5) {
				if (localValue == myCounter) {
					LOGGER.debug("Got Change for MY_INT : " + myCounter);
					localValue = myCounter;
				}
			}
		}
	}

	static class ChangeMaker extends Thread {
		@Override
		public void run() {

			int localValue = myCounter;
			while (myCounter < 5) {
				LOGGER.debug("Incrementing MY_INT to " + (localValue + 1));
				myCounter = ++localValue;
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					LOGGER.error(e);
					Thread.currentThread().interrupt();
				}
			}
		}
	}
}
