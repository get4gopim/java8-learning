package com.bootexample.product.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bootexample.product.model.Product;

@RestController
public class ProductService {
	
	private static List<Product> products = new ArrayList<>();
	
	static {
		products.add(new Product(1, "Firestick", 3499));
		products.add(new Product(2, "Redmi Note 4 64 GB", 12999));
		products.add(new Product(3, "Amazon Kindle Paper", 10999));
	}
	
	@RequestMapping("/product")
	private Product getProduct(@RequestParam(name="id") int id) {
		Product product = null;
		
		for (Product p : products) {
			if (p.getId() == id) {
				product = p;
			}
		}
		
		return product;
	}

}
