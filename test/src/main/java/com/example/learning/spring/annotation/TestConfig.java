package com.example.learning.spring.annotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestConfig {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = null;
		try {
			ctx = new AnnotationConfigApplicationContext(AppConfig.class);
			IMovieFinder movieFinder = ctx.getBean("movieFinder", IMovieFinder.class);

			System.out.println("movie = " + movieFinder.fineMovie("Games of Thrones"));

			Movie movie = ctx.getBean("testMovie", Movie.class);
			System.out.println("default Movie = " + movie.toString());

			Actress actress = ctx.getBean("actress", Actress.class);
			System.out.println("actress = " + actress.toString());
			
			//DataSource dataSource = ctx.getBean("dataSource", DataSource.class);
			//System.out.println("DataSource = " + dataSource.toString());

		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			ctx.registerShutdownHook();
		}
	}

}
