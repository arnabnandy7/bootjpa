package com.arnab.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BootjpaApplication {
	// To check H2 database connect with http://localhost:8080/h2-console/
	// Change the JDBC URL with jdbc:h2:mem:arnabjpa
	// Press connect, DONOT CHANGE ANY OTHER SETTINGS
	
	private static final Logger logger = LoggerFactory.getLogger(BootjpaApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BootjpaApplication.class, args);
		logger.info("Application initiated");
	}

}
