package com.example.learning.spring.annotation;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestConfig {

	private static final Logger LOGGER = Logger.getLogger(TestConfig.class);
	
	public static void main(String[] args) {
		try (AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class)) {
			IMovieFinder movieFinder = ctx.getBean("movieFinder", IMovieFinder.class);

			LOGGER.debug("movie = " + movieFinder.fineMovie("Games of Thrones"));

			Movie movie = ctx.getBean("testMovie", Movie.class);
			LOGGER.debug("default Movie = " + movie.toString());

			Actress actress = ctx.getBean("actress", Actress.class);
			LOGGER.debug("actress = " + actress.toString());
			
			DataSource dataSource = ctx.getBean("dataSource", DataSource.class);
			LOGGER.debug("DataSource = " + dataSource.toString());

		} catch(Exception e) {
			LOGGER.error(e);
		}
	}

}
