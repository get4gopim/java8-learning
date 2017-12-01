package com.example.interview.basics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorMain {

	public static void main(String[] args) throws Exception {
		List<Student> list = new ArrayList<>();
		list.add(new Student(1, "Trowl", 85));
		list.add(new Student(2, "Zoring", 19));
		list.add(new Student(2, "Andrio", 19));
		list.add(new Student(3, "Birna", 28));
		
		list.stream().forEach(stu -> System.out.println(stu.getName()) );
		
		System.out.println("************ SORTED ************");
		Collections.sort(list);
		list.stream().forEach(stu -> System.out.println(stu.toString()) );
		
		System.out.println("************ SORTED ************");
		Collections.sort(list, ageAndNameComparator);
		list.stream().forEach(stu -> System.out.println(stu.toString()) );
		
	}
	
	public static Comparator<Student> ageAndNameComparator = new Comparator<Student>() {

		@Override
		public int compare(Student o1, Student o2) {
			int flag = o1.getAge() - o2.getAge();
			if (flag == 0) flag = o1.getName().compareTo(o2.getName());
			return flag;
		}
		
		
	};
		

	
}
