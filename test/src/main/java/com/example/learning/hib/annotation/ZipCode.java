package com.example.learning.hib.annotation;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "zipcode")
public class ZipCode {

	@Column(name = "pincode")
	private String pincode;
	
	@Column(name = "state")
	private String state;
	
	@Column(name = "city")
	private String city;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<Student> students;

	public ZipCode() {

	}

	public ZipCode(String pincode, String state, String city) {
		super();
		this.pincode = pincode;
		this.state = state;
		this.city = city;
	}

	@Override
	public String toString() {
		return "ZipCode [pincode=" + pincode + ", state=" + state + ", city=" + city + "]";
	}

}
