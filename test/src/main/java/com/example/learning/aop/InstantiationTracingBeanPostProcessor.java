package com.example.learning.aop;

import org.springframework.beans.factory.config.BeanPostProcessor;

public class InstantiationTracingBeanPostProcessor implements BeanPostProcessor {

	// simply return the instantiated bean as-is
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) {
		System.out.println("Bean '" + beanName + "' intiliazing : " + bean.toString());
		return bean; // we could potentially return any object reference here...
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) {
		System.out.println("Bean '" + beanName + "' created : " + bean.toString());
		return bean;
	}

}
