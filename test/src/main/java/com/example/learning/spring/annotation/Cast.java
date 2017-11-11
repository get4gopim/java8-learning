package com.example.learning.spring.annotation;

import java.util.Date;

public abstract class Cast {

	private String name;
	private Date born;
	private int noOfMovies;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBorn() {
		return born;
	}

	public void setBorn(Date born) {
		this.born = born;
	}

	public int getNoOfMovies() {
		return noOfMovies;
	}

	public void setNoOfMovies(int noOfMovies) {
		this.noOfMovies = noOfMovies;
	}
	
	@Override
	public String toString() {
		return "Actress [name=" + getName() + "]";
	}

	public Cast(String name) {
		super();
		this.name = name;
	}

}
