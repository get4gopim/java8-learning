package com.example.learning.java8;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

import org.apache.log4j.Logger;

public class MathOperationDemo {

	private static final Logger LOGGER = Logger.getLogger(MathOperationDemo.class);

	public static void main(String[] args) {
		// test2();
		test221();
	}

	private static void test221() {
		List<Employee> list = new ArrayList<>();
		list.add(new Employee("Tyiron", 7192302));
		list.add(new Employee("Arya", 8192302));
		list.add(new Employee("Rickon", 6192302));
		
		//list.forEach(emp -> System.out.println(emp.toString()));
		list.forEach(System.out::println);
		
		
		
		System.out.println("********** FILTERED ********");
		list.stream().filter(emp -> emp.getEmpId() != 6192302).forEach(System.out::println);
		
		System.out.println("********** AFTER ********");
		list.forEach(System.out::println);
		
		System.out.println("********** AFTER - 2222 ********");
		Collection<Employee> c = list;
		Predicate<Employee> p1 = emp -> emp.getEmpId() != 6192302;
		c.removeIf(p1);
		list.forEach(System.out::println);
	}

	private static void test2() {
		MathOperationDemo tester = new MathOperationDemo();

		MathOperation addition = (a, b) -> a + b;
		MathOperation sub = (a, b) -> a - b;
		MathOperation multiply = (a, b) -> a * b;
		MathOperation div = (a, b) -> a / b;

		LOGGER.debug("addition: " + tester.operate(5, 10, addition));
		LOGGER.debug("sub: " + tester.operate(15, 5, sub));
		LOGGER.debug("multiply: " + tester.operate(15, 3, multiply));
		LOGGER.debug("div: " + tester.operate(10, 5, div));

		Function<Integer, Integer> add = y -> y + 1;
		System.out.println("Function.add = " + add.apply(1));

		Function<Double, Function<Double, Double>> add1 = x -> y -> Math.pow((x + y), 2);
		System.out.println("Function.add1 = " + add1.apply(1d).apply(2d));

		Thread t = new Thread(() -> {
			System.out.println("A:");
		});
		t.start();

		new Thread(() -> {
			for (int i = 1; i < 10; i++)
				System.out.println(i);
		}).start();
		;

		Runnable runnable = () -> {
			System.out.println("b:");
		};

		Thread t1 = new Thread(runnable);

		System.out.println(invert.apply(48));
	}

	static Function<Integer, Integer> invert = x -> -x;

	interface MathOperation {
		int operation(int a, int b);
	}

	private int operate(int a, int b, MathOperation mathOperation) {
		return mathOperation.operation(a, b);
	}
}

class Employee {
	private String name;
	private int empId;

	public Employee(String name, int empId) {
		super();
		this.name = name;
		this.empId = empId;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", empId=" + empId + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

}
