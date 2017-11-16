package com.bootexample.customer.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bootexample.customer.model.Customer;

@RestController
public class CustomerService {
	
	private static List<Customer> customers = new ArrayList<>();

	static {
		customers.add(new Customer(1, "Bran Stark", "123456"));
		customers.add(new Customer(2, "Arya Stark", "123457"));
		customers.add(new Customer(3, "Sansa Stark", "123458"));
		customers.add(new Customer(4, "Robb Stark", "123459"));
		customers.add(new Customer(5, "Rickon Stark", "123450"));
		customers.add(new Customer(6, "Jon Snow", "123451"));
		customers.add(new Customer(7, "Nerd Stark", "123452"));
		customers.add(new Customer(8, "Lyanna Stark", "123453"));
	}
	
	@RequestMapping("/customer")
	private Customer getCustomer(@RequestParam(name="id", defaultValue="1") int id) {
		Customer customer = null;
		
		for (Customer cust : customers) {
			if (cust.getId() == id) {
				customer = cust;
			}
		}
		
		return customer;
	}
}
