package com.example.interview.basics;

import java.util.Arrays;

import com.example.interview.basics.OuterClass.NonStaticInnerClass;

abstract class ABC {
	
	void test() {
		
	}
	
	abstract void me();
}

interface OuterService {
	
	void accessOuter();
	
	interface InnerService {
		
		void accessInner();
		
	}
}

class OuterClass {
	private String name = "Default Name";
	
	private static Integer versionId = 2;
	
	public String studentName = "Jaienl"; 

	public OuterClass(OuterService service) {
		service.accessOuter();
	}
	
	public OuterClass() {
	}
	
	public String getName() {
		return this.name;
	}
	
	public static String processHeaders() {
		return " curl -X GET http://localhost:4800";
	}
	
	InnerClass inner = new InnerClass();

	static class InnerClass {
		
		public void m1() {
			System.out.println("Non static innerClass.m1 = "  + versionId);
		}
		
		public static void m2() {
			System.out.println("static InnerClass.m2 = " + versionId + " :: outerClass.processHeaders::" + processHeaders());
		}
	}
	
	class NonStaticInnerClass {
		
		int i = 10;
		
		public void nonM1() {
			System.out.println("Non static innerClass.m1 = "  + versionId + " :: " + studentName);
		}
		
		public void nonM2() { // !! cannot be static  !!
			
		}
	}
}



public class OuterClassSample {
	
	private Integer count = 5;
	private static String name = "CLASS>SIMMPLE";
	
	public static void main(String... strings) {
		OuterClass clazz = new OuterClass();
		System.out.println(clazz.studentName);
		clazz.inner.m1();
		clazz.inner.m2(); // OuterClass.InnerClass.m2();
		
		System.out.println(" ********* Static Inner ************ ");
		
		OuterClass.InnerClass inner = new OuterClass.InnerClass();
		inner.m1();
		OuterClass.InnerClass.m2();
		
		System.out.println(" ********** NonStaticInnerClass *********** ");
		
		NonStaticInnerClass nonInner = new OuterClass().new NonStaticInnerClass();
		nonInner.nonM1();
		
		System.out.println(" ********** Annoynmous Obj *********** ");
		OuterService o1 = new OuterService() {
			
			@Override
			public void accessOuter() {
				System.out.println("accessOuter impl");
			}
		};
		o1.accessOuter();
		
		OuterClass p1 = new OuterClass() {

			@Override
			public String getName() {
				// TODO Auto-generated method stub
				return "I'm Anonymous ...";
			}
			
		};
		System.out.println(p1.getName());
		
		Thread t = new Thread(new Runnable() {
			
			int i = 10;
			final static int st = 10;
			// static int j = 10; // not allowed
			
			@Override
			public void run() {
				Arrays.asList(1, 2, 3, 4, 5).forEach(System.out::print);
			}
			
			public void test() {
				System.out.println("Access static :: " + name + "; non-static :: ");
			}
		});
		t.start();
		
		Thread t1 = new Thread() {
			@Override
			public void run() {
				Arrays.asList(1, 2, 3, 4, 5).forEach(System.out::print);
			}
			
			public void test() {
				System.out.println("Access static :: " + name + "; non-static :: ");
			}
		};
		
		ABC a1 = new ABC() {
			
			@Override
			void me() {
				System.out.println("Abtract overriden");				
			}
			
			@Override
			protected void test() {
				
			}
		};
		
		a1.test();
	}
}
