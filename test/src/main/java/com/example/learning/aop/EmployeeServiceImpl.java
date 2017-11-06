package com.example.learning.aop;

import org.springframework.stereotype.Service;

@Service(value="employeeService")
public class EmployeeServiceImpl implements EmployeeService {

	@Override
	public Employee findEmployeeByName(String name) {
		return new Employee().setName(name);
	}
}
