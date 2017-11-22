package com.example.interview.basics;

public class MainApp {

	static {
		System.out.println("static block is invoked");
	}

	public static void main(String[] args) {
		new MyClass();
		new MyClass();
		new MyClass();
		new MyClass();

		System.out.println(String.format("Current Object Count: %s", MyClass.count));
		
		IAudit audit = new IAudit() {
			
			@Override
			public String getLastModified() {
				return "20/11/2017 04:39 PM";
			}
		};
		
		System.out.println(audit.getLastModified());
		
	}

}
