package com.arnab.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class CustomBeanPostProcessor implements BeanPostProcessor {
	private static final Logger logger = LoggerFactory.getLogger(CustomBeanPostProcessor.class);

	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		logger.info("::::: Called postProcessBeforeInitialization() for ::::" + beanName);
		return bean;
	}

	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		logger.info(":::: Called postProcessAfterInitialization() for :::::" + beanName);
		return bean;
	}
}
