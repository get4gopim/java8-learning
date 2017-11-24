package com.example.learning.aop;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

@Service(value="employeeService")
public class EmployeeServiceImpl implements EmployeeService {

	public static final Logger LOGGER = Logger.getLogger(EmployeeServiceImpl.class);
	
	@Override
	public Employee findEmployeeByName(String name) {
		LOGGER.debug("inside EmployeeServiceImpl.findEmployeeByName(..)");
		return new Employee().setName(name);
	}
}
