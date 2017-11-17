package com.example.interview.threadlocal;

import org.apache.log4j.Logger;

public class SessionThread implements Runnable {
	
	private static final Logger LOGGER = Logger.getLogger(SessionThread.class);
	
	private ThreadLocal<String> contextId = new ThreadLocal<>();
	
	private InheritableThreadLocal<String> inheritContextId = new InheritableThreadLocal<>();
	
	private String localAssignment;
	
	SessionThread(String value) {
		this.localAssignment = value;
	}
	
	public String getContextId() {
		return contextId.get();
	}

	public void setContextId(String value) {
		contextId.set(value);
	}
	
	@Override
	public void run() {
		for (int i = 0; i<2; i++) {
			setContextId (this.localAssignment);
			
			inheritContextId.set(this.localAssignment);
			
			LOGGER.debug("Thread: " + Thread.currentThread().getName() + "; Context Id: " + inheritContextId.get());
		}
	}

}
