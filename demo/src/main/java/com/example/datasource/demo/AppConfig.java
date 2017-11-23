package com.example.datasource.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.datasource.StudentDao;

@Configuration
public class AppConfig {

	@Bean
	public StudentDao studentDao() {
		return new StudentDao();
	}
}
