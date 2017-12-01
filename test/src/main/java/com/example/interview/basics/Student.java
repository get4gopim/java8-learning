package com.example.interview.basics;

public class Student implements Cloneable, Comparable<Student> {

	int id;
	String name;
	Course course;
	int age;
	
	public Student(int id, String name, int age) {
		this.id = id;
		this.name = name;
		this.age = age;
	}

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
	public int compareTo(Student o) {
		int flag = this.getAge() - o.getAge();
		if (flag == 0) flag = this.getName().compareTo(o.getName());
		return flag;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", age=" + age + ", course=" + course + "]";
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
