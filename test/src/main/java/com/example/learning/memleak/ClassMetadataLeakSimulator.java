package com.example.learning.memleak;

import java.lang.reflect.Proxy;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

/**
 * PermGenRemovalValidator
 * 
 * @author Pierre-Hugues Charbonneau
 * 
 */
public class ClassMetadataLeakSimulator {
	
	private static final Logger LOGGER = Logger.getLogger(ClassMetadataLeakSimulator.class);

	private static Map<String, ClassA> classLeakingMap = new HashMap<String, ClassA>();
	private final static int NB_ITERATIONS_DEFAULT = 50000;

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		LOGGER.debug("Class metadata leak simulator");
		LOGGER.debug("Author: Pierre-Hugues Charbonneau");
		LOGGER.debug("http://javaeesupportpatterns.blogspot.com");

		int nbIterations = (args != null && args.length == 1) ? Integer.parseInt(args[0]) : NB_ITERATIONS_DEFAULT;

		try {

			for (int i = 0; i < nbIterations; i++) {

				String fictiousClassloaderJAR = "file:" + i + ".jar";

				LOGGER.debug(fictiousClassloaderJAR);
				URL[] fictiousClassloaderURL = new URL[] { new URL(fictiousClassloaderJAR) };

				// Create a new classloader instance
				URLClassLoader newClassLoader = new URLClassLoader(fictiousClassloaderURL);
				
				// Create a new Proxy instance
				ClassA t = (ClassA) Proxy.newProxyInstance(newClassLoader,
						new Class<?>[] { ClassA.class },
						new ClassAInvocationHandler(new ClassAImpl()));
				
				// Add the new Proxy instance to the leaking HashMap
				classLeakingMap.put(fictiousClassloaderJAR, t);
			}
		} 
		catch (Throwable any) {
			LOGGER.debug("ERROR: " + any);
		}

		LOGGER.debug("Done!");
	}
}