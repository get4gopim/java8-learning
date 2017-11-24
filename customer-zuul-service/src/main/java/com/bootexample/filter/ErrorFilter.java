package com.bootexample.filter;

import com.netflix.zuul.ZuulFilter;

public class ErrorFilter extends ZuulFilter {

	public ErrorFilter() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() {
		System.out.println("Using Error Filter");
		return null;
	}

	@Override
	public String filterType() {
		return "error";
	}

	@Override
	public int filterOrder() {
		return 0;
	}

}
