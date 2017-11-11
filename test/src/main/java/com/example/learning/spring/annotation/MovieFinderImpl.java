package com.example.learning.spring.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("movieFinder")
public class MovieFinderImpl implements IMovieFinder {
	
	@Autowired
	private IMovieDao movieDao;

	@Override
	public Movie fineMovie(String name) {
		return movieDao.findMovieByName(name);
	}

}
