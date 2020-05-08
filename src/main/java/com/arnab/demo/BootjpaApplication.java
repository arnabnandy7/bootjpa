package com.arnab.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class BootjpaApplication {
	// To check H2 database connect with http://localhost:8080/h2-console/
	// Change the JDBC URL with jdbc:h2:mem:arnabjpa
	// Press connect, DONOT CHANGE ANY OTHER SETTINGS

	public static void main(String[] args) {
		SpringApplication.run(BootjpaApplication.class, args);
	}

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.arnab.demo.controller")) // // Generate API of
																						// EndPoints which is
																						// available inside
																						// defined package
				.paths(PathSelectors.any()) // for all EndPoints
				.build(); // create object
	}

}
