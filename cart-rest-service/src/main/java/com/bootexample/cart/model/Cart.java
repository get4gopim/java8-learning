package com.bootexample.cart.model;

public class Cart {

	private int id;
	private Customer customer;
	private Product product;

	public Cart() {
	}

	public Cart(int id, Customer customer, Product product) {
		super();
		this.id = id;
		this.customer = customer;
		this.product = product;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}
