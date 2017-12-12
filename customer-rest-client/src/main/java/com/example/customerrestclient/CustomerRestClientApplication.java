package com.example.customerrestclient;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.client.RestTemplate;

import com.bootexample.customer.model.Customer;

@SpringBootApplication
public class CustomerRestClientApplication implements CommandLineRunner {
	
	public static final String URL = "http://localhost:8081/customer?id={id}";
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private LoadBalancerClient discoveryClient;
	
	@Autowired
	private DiscoveryClient discoveryClient1;
	
	public static void main(String[] args) {
		SpringApplication.run(CustomerRestClientApplication.class, args);
	}
	
	private String getURLFromEurka() {
		List<ServiceInstance> list = discoveryClient1.getInstances("customer-rest-service");
		ServiceInstance instanceInfo = list.get(0);
		
		return instanceInfo.getUri().toString() + "/customer?id={id}";
	}
	
	private String getURLFromZuul() {
		ServiceInstance instanceInfo = discoveryClient.choose("customer-zuul-service");
		
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
