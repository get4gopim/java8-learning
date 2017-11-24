package com.example.customerrestclient;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.client.support.BasicAuthorizationInterceptor;
import org.springframework.web.client.RestTemplate;

import com.bootexample.customer.model.Customer;

@SpringBootApplication
public class CustomerRestClientApplication implements CommandLineRunner {
	
	public static final String URL = "http://localhost:8081/customer?id={id}";
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private DiscoveryClient discoveryClient;
	
	public static void main(String[] args) {
		SpringApplication.run(CustomerRestClientApplication.class, args);
	}
	
	private String getURL() {
		List<ServiceInstance> list = discoveryClient.getInstances("customer-rest-service");
		ServiceInstance instanceInfo = list.get(0);
		
		return instanceInfo.getUri().toString() + "/customer?id={id}";
	}
	
	private String getURLFromZuul() {
		List<ServiceInstance> list = discoveryClient.getInstances("customer-zuul-service");
		ServiceInstance instanceInfo = list.get(0);
		
		return instanceInfo.getUri().toString() + "/customer-rest-service/customer?id={id}";
	}

	@Override
	public void run(String... args) throws Exception {
		String url = getURLFromZuul();
		
		System.out.println(url);
		
		//restTemplate.getInterceptors().add(new BasicAuthorizationInterceptor("username", "pwd"));
		
		Customer customer = restTemplate.getForObject(url, Customer.class, 5);
		
		System.out.println(customer.toString());
	}
}
