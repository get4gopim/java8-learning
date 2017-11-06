package com.example.learning.aop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy // enables <aop:aspectj-autoproxy>
@ComponentScan(basePackages= {"com.example.learning.aop"})
public class MainConfiguration {

	@Bean(name="empService")
	public EmployeeService getEmployeeService() {
		return new EmployeeServiceImpl();
	}
	
	@Bean // the Aspect itself must also be a Bean
    public LoggingAspect getAspect() {
        return new LoggingAspect();
    }
}
