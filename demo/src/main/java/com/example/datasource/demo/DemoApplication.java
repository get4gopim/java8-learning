package com.example.datasource.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.datasource.StudentDao;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
	
	@Autowired
	private StudentDao studentDao;
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	public void run(String... args) throws Exception {
		System.out.println(studentDao.getData());
    }
}
