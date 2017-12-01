package com.example.learning.singletonpattern;

public enum SingletonEnum implements Runnable {
	
	INSTANCE(0);
	
	private int count;
	
	private SingletonEnum() {
		
	}
	
	SingletonEnum(int val) {
		count = val;
	}
	
	

	public String getConfig() {
		return this.name();
	}

	@Override
	public void run() {
		for (int i=0;i<10;i++) System.out.println(String.format("process[%d]", i));
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
}
