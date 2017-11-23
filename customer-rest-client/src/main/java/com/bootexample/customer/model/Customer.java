package com.bootexample.customer.model;

public class Customer {

	private int id;
	private String name;
	private String zipcode;

	public Customer() {

	}

	public Customer(int id, String name, String zipcode) {
		super();
		this.id = id;
		this.name = name;
		this.zipcode = zipcode;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", zipcode=" + zipcode + "]";
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

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

}
