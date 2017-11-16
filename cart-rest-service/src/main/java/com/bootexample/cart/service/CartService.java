package com.bootexample.cart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.bootexample.cart.model.Cart;
import com.bootexample.cart.model.Customer;
import com.bootexample.cart.model.Product;

@RestController
public class CartService {
	
	private int id = 0;
	
	@Autowired
	private RestTemplate restTemplate;
			
	@RequestMapping("/addToCart")
	private Cart addToCart(@RequestParam(name="custId") int custId, @RequestParam(name="prodId") int prodId) {
		Customer customer = restTemplate.getForObject("http://localhost:8080/customer?id={id}", Customer.class, custId);
		Product product = restTemplate.getForObject("http://localhost:8081/product?id={id}", Product.class, prodId);
		id++;
		
		return new Cart(id, customer, product);
	}

}
