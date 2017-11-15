package com.example.learning.spring;

import org.springframework.stereotype.Component;

@Component("phoneBook")
public class PhoneBook {

	private String phoneNumber;
	private String name;
	
	public PhoneBook() {
		
	}
	
	public PhoneBook(String phoneNumber, String name) {
		super();
		this.phoneNumber = phoneNumber;
		this.name = name;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "PhoneBook [phoneNumber=" + phoneNumber + ", name=" + name + "]";
	}
	
	
}
