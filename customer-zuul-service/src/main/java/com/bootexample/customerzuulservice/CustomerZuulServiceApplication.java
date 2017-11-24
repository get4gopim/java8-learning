package com.bootexample.customerzuulservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import com.bootexample.filter.ErrorFilter;
import com.bootexample.filter.PostFilter;
import com.bootexample.filter.PreFilter;
import com.bootexample.filter.RouteFilter;

@SpringBootApplication
@EnableZuulProxy
public class CustomerZuulServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerZuulServiceApplication.class, args);
	}
	
	@Bean
	public PreFilter preFilter() {
		return new PreFilter();
	}

	@Bean
	public PostFilter postFilter() {
		return new PostFilter();
	}

	@Bean
	public ErrorFilter errorFilter() {
		return new ErrorFilter();
	}

	@Bean
	public RouteFilter routeFilter() {
		return new RouteFilter();
	}
}
