package com.example.interview.basics;

import org.apache.log4j.Logger;

public class CloneMain {
	
	private static final Logger LOGGER = Logger.getLogger(CloneMain.class);

	public static void main(String[] args) throws Exception {
		Student s1 = new Student(123, "Gopi", new Course("Maths", "Physics", "Chemistry"));
		Student s2 = (Student) s1.clone();
		
		Course course = s2.getCourse();
		course.setSubject3("Biology");
		s2.setCourse(course);
		
		LOGGER.debug(s1);
		LOGGER.debug(s2);
	}
}
