package com.example.learning.aop;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class LoginController {

	public static final Logger LOGGER = Logger.getLogger(LoginController.class);
	
	@Autowired
	private EmployeeService empService;
	
	public void login(String username, String pwd) {
		LOGGER.info("using reference:: " + empService);
		
		Employee e = empService.findEmployeeByName(username);
		LOGGER.info(e.toString());
	}
}
