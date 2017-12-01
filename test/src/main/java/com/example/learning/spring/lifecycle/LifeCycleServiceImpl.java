package com.example.learning.spring.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class LifeCycleServiceImpl implements LifeCycleService, BeanNameAware, BeanClassLoaderAware, BeanFactoryAware,
		BeanPostProcessor, InitializingBean, DisposableBean {

	public LifeCycleServiceImpl() {
		System.out.println("LifeCycleService Instantiation ...");
	}

	@Override
	public String getName() {
		return "dummy service name";
	}

	@Override
	public void setBeanName(String name) {
		System.out.println("Step 3: BeanNameAware.setBeanName");
	}

	@Override
	public void setBeanClassLoader(ClassLoader classLoader) {
		System.out.println("Step 4: BeanClassLoaderAware.setBeanClassLoader");

	}

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		System.out.println("Step 5: BeanFactoryAware.setBeanFactory");
	}

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("Step 6: BeanPostProcessor.postProcessBeforeInitialization");
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("Step 9: BeanPostProcessor.postProcessAfterInitialization");
		return bean;
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("Step 10: DisposableBean.destroy");

	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("Step 7: InitializingBean.afterPropertiesSet");
	}
	
	public void customInit() {
		System.out.println("Step 8: init-method");
	}
	
	public void customDestroy() {
		System.out.println("Step 11: destroy-method");
	}

}
