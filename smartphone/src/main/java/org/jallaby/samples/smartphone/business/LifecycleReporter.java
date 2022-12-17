package org.jallaby.samples.smartphone.business;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LifecycleReporter {
	private static final Logger LOGGER = LoggerFactory.getLogger(LifecycleReporter.class);
	
	public void reportPostConstruct(Class<?> clazz) {
		LOGGER.info(String.format("Called @PostConstruct on class [%s]", clazz.getCanonicalName()));
	}

	public void reportPreDestroy(Class<?> clazz) {
		LOGGER.info(String.format("Called @PreDestroy on class [%s]", clazz.getCanonicalName()));
	}
}
