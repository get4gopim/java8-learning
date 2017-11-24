package com.example.learning.hib.annotation;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;

import com.example.learning.hibernate.util.HibernateUtil;

public class DemoMain {
	
	private static final Logger LOGGER = Logger.getLogger(DemoMain.class);

	public static void main(String[] args) {
		try {
			HibernateUtil util = new HibernateUtil("annotation/hibernate.cfg.xml");

			Department d1 = new Department("UKG-B");
			
			University univ = new University("SSBV GJCS", "India");
			University univ2 = new University("MKV", "US");
			
			Set<Student> listStudents = new HashSet<>();
			Student stu1 = new Student("Lakshana");
			stu1.setDepartment(d1);
			stu1.setUniversity(univ);
			listStudents.add(stu1);
			
			Student stu2 = new Student("Dhosika");
			stu2.setDepartment(d1);
			stu2.setUniversity(univ);
			listStudents.add(stu2);
			
			Student stu3 = new Student("Guru Prasad");
			stu3.setDepartment(d1);
			stu3.setUniversity(univ2);
			listStudents.add(stu3);
			
			d1.setStudents(listStudents);
			
			util.update(d1);

			Collection<Student> list = util.list(Student.class);
			for (Student entity : list) {
				LOGGER.debug(entity.toString());
			}
			
			LOGGER.debug("filterd results ....");
			List<Student> students = util.getStudentByUniversityName("SSBV GJCS");
			for (Student entity : students) {
				LOGGER.debug(entity.toString());
			}
			
			LOGGER.debug("getStudentByName ....");
			students = util.getStudentByName("Lakshana");
			for (Student entity : students) {
				LOGGER.debug(entity.toString());
			}
			
			util.close();
		} catch (Exception ex) {
			LOGGER.error(ex);
		} finally {
			
			HibernateUtil.getSessionFactory().close();
		}

	}

}
