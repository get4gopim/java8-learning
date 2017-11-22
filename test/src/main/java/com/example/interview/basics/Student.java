package com.example.interview.basics;

public class Student implements Cloneable {

	int id;
	String name;
	Course course;

	public Student(int id, String name, Course course) {
		super();
		this.id = id;
		this.name = name;
		this.course = course;
	}
	
	public Object clone() throws CloneNotSupportedException {
		Student stu = (Student) super.clone();
		stu.course = (Course) this.course.clone(); // to avoid shallow copy the object cloned from its own class.
		return stu;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", course=" + course + "]";
	}
}
