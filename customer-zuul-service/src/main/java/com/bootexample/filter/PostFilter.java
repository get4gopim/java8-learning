package com.bootexample.filter;

import com.netflix.zuul.ZuulFilter;

public class PostFilter extends ZuulFilter {

	public PostFilter() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() {
		System.out.println("Using Post Filter");
		return null;
	}

	@Override
	public String filterType() {
		return "post";
	}

	@Override
	public int filterOrder() {
		return 0;
	}

}
