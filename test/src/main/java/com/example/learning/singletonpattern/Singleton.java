package com.example.learning.singletonpattern;

import java.io.ObjectStreamException;
import java.io.Serializable;

public class Singleton implements Cloneable, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Singleton() {
		if (Holder.INSTANCE != null) {
			throw new RuntimeException("Instance already exists !!!");
		}
		System.out.println("INSTANCE will be created... ");
	}
	
	static class Holder {
		public static final Singleton INSTANCE = new Singleton();
	}
	
	public static Singleton getInstance() throws Exception {
		return Holder.INSTANCE;
	}
	
	protected Object clone() throws CloneNotSupportedException {
		return Holder.INSTANCE;
		// return super.clone();
	}
	
	private Object readResolve() throws ObjectStreamException {
		return Holder.INSTANCE;
	}

}
