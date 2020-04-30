package com.arnab.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BootjpaApplication {
	// To check H2 database connect with http://localhost:8080/h2-console/
	// Change the JDBC URL with jdbc:h2:mem:arnabjpa
	// Press connect, DONOT CHANGE ANY OTHER SETTINGS

	public static void main(String[] args) {
		SpringApplication.run(BootjpaApplication.class, args);
	}

}
