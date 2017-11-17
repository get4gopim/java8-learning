package com.example.interview.countdownlatch;

import java.util.concurrent.CountDownLatch;

import org.apache.log4j.Logger;

public class Service implements Runnable {
	
	private static final Logger LOGGER = Logger.getLogger(Service.class);
	
	private final String name;
    private final int timeToStart;
    private final CountDownLatch latch;
  
    public Service(String name, int timeToStart, CountDownLatch latch){
        this.name = name;
        this.timeToStart = timeToStart;
        this.latch = latch;
    }
  
    @Override
    public void run() {
        try {
        	LOGGER.debug( name + " is yet to start... ");
            Thread.sleep(timeToStart);
        } catch (InterruptedException ex) {
            LOGGER.debug(ex);
            Thread.currentThread().interrupt();
        }
        LOGGER.debug( name + " is Up");
        latch.countDown(); //reduce count of CountDownLatch by 1
    }

}
