package com.example.learning.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class LoggingAspect {
	
	public static final Logger LOGGER = Logger.getLogger(LoggingAspect.class);

	@Before("execution(* com.example.learning.aop.EmployeeServiceImpl.findEmployeeByName(..))")
	public void logBefore(JoinPoint joinPoint) {
		LOGGER.info("logBefore...");
	}
}
