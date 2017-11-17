package com.example.learning.spring.annotation;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.apache.log4j.Logger;

public class Actress extends Cast {
	
	private static final Logger LOGGER = Logger.getLogger(Actress.class);

	public Actress(String name) {
		super(name);
		LOGGER.debug("Actress initialized::" + name);
	}

	private int waist;

	public int getWaist() {
		return waist;
	}

	public void setWaist(int waist) {
		this.waist = waist;
	}
	
	@PostConstruct
	public void afterConstruct() {
		LOGGER.debug("@PostConstruct ..." + this.getName());
	}
	
	@PreDestroy
	public void beforeDestroy() {
		LOGGER.debug("@PreDestroy ..." + this.getName());
	}

}
