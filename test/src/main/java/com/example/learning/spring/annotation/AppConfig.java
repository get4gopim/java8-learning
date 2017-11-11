package com.example.learning.spring.annotation;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Lazy;

@Configuration
@ComponentScan(basePackages = {"com.example.learning.spring.annotation"})
@ImportResource("classpath:/connection.properties")
public class AppConfig {
	
	@Value("${jdbc.url}")
	private String jdbcURL;
	
	@Value("${jdbc.username}")
	private String jdbcUsername;
	
	@Value("${jdbc.password}")
	private String jdbcPassword;
	
	@Bean
	public DataSource dataSource() {
		return new DataSource(jdbcURL, jdbcUsername, jdbcPassword);
	}
	
	@Bean
	@Qualifier("defaultMovie")
	public Movie getMovie() {
		return new Movie("name", new Actress("actress"), new Actor("actor"));
	}
	
	@Bean
	@Lazy
	public Actress actress() {
		return new Actress("lazyActress");
	}
	
	@Bean(name="testMovie")
	@Description("Movie bean description")
	public Movie getService(@Qualifier("defaultMovie") Movie movie, @Value("#{getYetAnotherMovie.name}") String movieName) {
		movie.setName(movieName);
		return movie;
	}
	
	@Bean
	public Movie getYetAnotherMovie() {
		return new Movie("Avatar", new Actress("James Camron"), new Actor("Shyron Dev"));
	}

}
