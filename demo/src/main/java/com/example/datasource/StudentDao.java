package com.example.datasource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.example.datasource.model.Student;

@Component
public class StudentDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<Student> getData() {
		return jdbcTemplate.query("select * from t_student", (rs, rownum) -> new Student(rs.getInt(1), rs.getString(2)));
	}

}
