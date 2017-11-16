package com.example.interview.countdownlatch;

import java.util.concurrent.CountDownLatch;

public class Service implements Runnable {
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
        	System.out.println( name + " is yet to start... ");
            Thread.sleep(timeToStart);
        } catch (InterruptedException ex) {
            System.out.println(ex);
        }
        System.out.println( name + " is Up");
        latch.countDown(); //reduce count of CountDownLatch by 1
    }

}
