package com.example.interview.countdownlatch;

public class StackOverFlowTest {

	static int i = 0;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		callMe();
	}
	
	public static void callMe() throws Exception {
		if (i != 1000) {
			if ((i % 100) == 0) {
				Thread.sleep(1000);
			}
			
			callMe();
		}
		i++;
	}

}
