package com.example.learning.aop;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

public class CustomBeanFactory implements BeanFactoryPostProcessor {

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		for (String beanName : beanFactory.getBeanDefinitionNames()) {
			System.out.println("beanName:: " + beanName);
            BeanDefinition beanDefinition = beanFactory.getBeanDefinition(beanName);

            // Manipulate the beanDefiniton or whatever you need to do

        }
		
	}

}
