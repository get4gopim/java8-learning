package com.example.learning.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class LoggingAspect {
	
	public static final Logger LOGGER = Logger.getLogger(LoggingAspect.class);

	@Before("execution(* com.example.learning.aop.EmployeeServiceImpl.findEmployeeByName(..))")
	public void logBefore(JoinPoint joinPoint) {
		LOGGER.info("logBefore..." + joinPoint.getTarget());
	}
	
	@After("execution(* com.example.learning.aop.EmployeeServiceImpl.findEmployeeByName(..))")
	public void logAfter(JoinPoint joinPoint) {
		LOGGER.info("logAfter...");
	}
	
	@Around("execution(* com.example.learning.aop.EmployeeServiceImpl.findEmployeeByName(..))")
	public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
		long start = System.currentTimeMillis();
		
		Object proceed = joinPoint.proceed();
		
		long executionTime = System.currentTimeMillis() - start;
		LOGGER.info(joinPoint.getSignature() + " executed in " + executionTime + "ms");
		
		return proceed;
	}
}
