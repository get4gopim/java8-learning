package com.example.interview.threadlocal;

public class SessionThread implements Runnable {
	
	private ThreadLocal<String> CONTEXT_ID = new ThreadLocal<>();
	
	private InheritableThreadLocal<String> INHERIT_CONTEXT_ID = new InheritableThreadLocal<>();
	
	private String _localAssignment;
	
	SessionThread(String value) {
		//CONTEXT_ID.set(value);
		this._localAssignment = value;
	}
	
	public String getContextId() {
		return CONTEXT_ID.get();
	}

	public void setContextId(String value) {
		CONTEXT_ID.set(value);
	}
	
	@Override
	public void run() {
		for (int i = 0; i<2; i++) {
			setContextId (this._localAssignment);
			
			INHERIT_CONTEXT_ID.set(this._localAssignment);
			
			//System.out.println("Thread: " + Thread.currentThread().getName() + "; Context Id: " + getContextId() + "; " + SessionContext.get());
			
			System.out.println("Thread: " + Thread.currentThread().getName() + "; Context Id: " + INHERIT_CONTEXT_ID.get());
		}
	}

}
