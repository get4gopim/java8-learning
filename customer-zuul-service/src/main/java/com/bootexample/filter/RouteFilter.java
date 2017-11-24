package com.bootexample.filter;

import com.netflix.zuul.ZuulFilter;

public class RouteFilter extends ZuulFilter {

	public RouteFilter() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() {
		System.out.println("Using Route Filter");
		return null;
	}

	@Override
	public String filterType() {
		return "route";
	}

	@Override
	public int filterOrder() {
		return 0;
	}

}
