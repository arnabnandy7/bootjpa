package com.arnab.demo.Service;

import javax.servlet.ServletContext;

import org.springframework.web.context.ServletContextAware;

public class DummyService implements ServletContextAware {

	ServletContext servletContext;

	@Override
	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}
}