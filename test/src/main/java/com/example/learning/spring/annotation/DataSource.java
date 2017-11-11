package com.example.learning.spring.annotation;

public class DataSource {

	private String jdbcURL;
	
	private String jdbcUsername;
	
	private String jdbcPassword;

	public DataSource(String jdbcURL, String jdbcUsername, String jdbcPassword) {
		super();
		this.jdbcURL = jdbcURL;
		this.jdbcUsername = jdbcUsername;
		this.jdbcPassword = jdbcPassword;
	}

	@Override
	public String toString() {
		return "DataSource [jdbcURL=" + jdbcURL + ", jdbcUsername=" + jdbcUsername + ", jdbcPassword=" + jdbcPassword
				+ "]";
	}
	
	
}
