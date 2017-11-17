package com.example.interview.threadlocal;

public class SessionDemo {

	public static void main(String[] args) {
		Thread t1 = new Thread(new SessionThread("cecgalaaep1-2017297054015-8"));
		Thread t2 = new Thread(new SessionThread("FINEST|CXI|10258"));
		
		t1.start();
		t2.start();
		
		Thread t3 = new Thread(new SessionThreadChild("ACD-23"));
		Thread t4 = new Thread(new SessionThreadChild("ACD-9280"));
		
		t3.start();
		t4.start();
		
	}

}
