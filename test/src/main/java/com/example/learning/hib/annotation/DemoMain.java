package com.example.learning.hib.annotation;

import java.util.Collection;

import com.example.learning.hibernate.util.HibernateUtil;

public class DemoMain {

	public static void main(String[] args) {
		HibernateUtil util = new HibernateUtil("annotation/hibernate.cfg.xml");
		
		Student stu1 = new Student("Lakshana");
		
		util.update(stu1);
		/*util.update(new Student("Doshika"));
		util.update(new Student("Guru Prasad"));
		util.update(new Student("Manikandan"));*/
		
		Department d1 = new Department("CS");
		d1.getStudents().add(stu1);
		util.update(d1);
		
		Collection<Department> list = util.list(Department.class);
		for (Department dep : list) {
			System.out.println(dep.toString());
		}
		
		System.exit(1);
	}

}
