package com.example.learning.hib.annotation;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "department")
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "department_id")
	private int id;

	@Column(name = "department_name")
	private String name;

	//@ManyToOne(targetEntity = Student.class, fetch = FetchType.EAGER)
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "department", targetEntity = Student.class)
	private List<Student> students;

	public Department() {

	}

	public Department(String name) {
		this.name = name;
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

	public List<Student> getStudents() {
		return (students == null ? new ArrayList<>() : students);
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + ", students=" + students + "]";
	}

}
