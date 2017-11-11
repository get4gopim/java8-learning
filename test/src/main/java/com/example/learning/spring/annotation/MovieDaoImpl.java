package com.example.learning.spring.annotation;

import org.springframework.stereotype.Repository;

@Repository
public class MovieDaoImpl implements IMovieDao {
	
	@Override
	public Movie findMovieByName(String name) {
		return new Movie(name, new Actress("Dannerys Targaryan"), new Actor("Jon Snow"));
	}

}
