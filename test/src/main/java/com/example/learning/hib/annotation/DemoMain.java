package com.example.learning.hib.annotation;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import com.example.learning.hibernate.util.HibernateUtil;

public class DemoMain {

	public static void main(String[] args) {
		try {
			HibernateUtil util = new HibernateUtil("annotation/hibernate.cfg.xml");

			Department d1 = new Department("UKG-B");
			
			Set<Student> listStudents = new HashSet<>();
			Student stu1 = new Student("Lakshana");
			stu1.setDepartment(d1);
			listStudents.add(stu1);
			
			Student stu2 = new Student("Dhosika");
			stu2.setDepartment(d1);
			listStudents.add(stu2);			
			
			d1.setStudents(listStudents);			
			
			util.update(d1);

			Collection<Student> list = util.list(Student.class);
			for (Student entity : list) {
				System.out.println(entity.toString());
			}
			
			util.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

}
