package com.example.learning.aop;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ReportController {
	
	public static final Logger LOGGER = Logger.getLogger(ReportController.class);
	
	@Autowired
	private EmployeeService employeeService;

	public void getPendingReports(String username) {
		LOGGER.info("using reference:: " + employeeService);

		employeeService.findEmployeeByName(username);
	}
}
