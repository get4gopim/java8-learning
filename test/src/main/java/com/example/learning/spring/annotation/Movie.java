package com.example.learning.spring.annotation;

public class Movie {

	private String name;
	private Actress actress;
	private Actor actor;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Actress getActress() {
		return actress;
	}

	public void setActress(Actress actress) {
		this.actress = actress;
	}

	public Actor getActor() {
		return actor;
	}

	public void setActor(Actor actor) {
		this.actor = actor;
	}

	@Override
	public String toString() {
		return "Movie [name=" + name  + ", " + actress + ", " + actor + "]";
	}

	public Movie(String name, Actress actress, Actor actor) {
		super();
		this.name = name;
		this.actress = actress;
		this.actor = actor;
	}
	
	public Movie() {
		
	}

}
