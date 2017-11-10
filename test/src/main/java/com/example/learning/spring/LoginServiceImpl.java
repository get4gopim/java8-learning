package com.example.learning.spring;

import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

	@Override
	public boolean isAuthenticated(String username, String password) {
		return true;
	}

}
