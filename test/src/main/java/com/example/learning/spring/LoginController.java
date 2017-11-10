package com.example.learning.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	public void login(String username, String password) {
		loginService.isAuthenticated(username, password);
	}

}
