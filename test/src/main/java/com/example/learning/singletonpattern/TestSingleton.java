package com.example.learning.singletonpattern;

import java.lang.reflect.Constructor;

public class TestSingleton {

	static Singleton obj1;

	static {
		try {
			obj1 = Singleton.getInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String... args) throws Exception {

		testBasicInstantiation();

		testReflection();

		testCloning();

		testEnum();
	}

	private static void testEnum() {
		SingletonEnum instance = SingletonEnum.INSTANCE;
	 System.out.println(instance.getConfig() + "::" + instance.getCount());
		/*Thread t = new Thread(instance);
		t.start();*/
		
		SingletonEnum instance1 = SingletonEnum.INSTANCE;
		instance1.setCount(100);
		System.out.println(instance.getCount());
		/*t = new Thread(instance);
		t.start();*/
	}

	private static void testCloning() throws CloneNotSupportedException {
		System.out.println("********** Clone TESTING *****");

		Singleton obj4 = (Singleton) obj1.clone();
		verify(obj1, obj4);
	}

	private static void testReflection() {
		System.out.println("********** Reflection TESTING *****");

		try {
			Class clazz = Class.forName("com.example.learning.singletonpattern.SingletonEnum");

			Constructor<SingletonEnum> constrcutor = clazz.getDeclaredConstructor();
			constrcutor.setAccessible(true);
			SingletonEnum obj3 = (SingletonEnum) constrcutor.newInstance();

			SingletonEnum senum = SingletonEnum.INSTANCE;
			verify(senum, obj3);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Could not be created");
		}
	}

	private static void testBasicInstantiation() throws Exception {
		System.out.println("********** BASIC TESTING *****");

		Singleton obj2 = Singleton.getInstance();
		verify(obj1, obj2);
	}

	public static void verify(Object obj1, Object obj2) {
		if (obj1.hashCode() != obj2.hashCode()) {
			System.out.println(String.format("Different Objects %d == %d", obj1.hashCode(), obj2.hashCode()));
		} else {
			System.out.println("SAME Reference");
		}
	}
}
