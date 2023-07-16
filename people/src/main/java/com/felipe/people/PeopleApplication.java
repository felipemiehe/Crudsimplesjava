package com.felipe.people;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootConfiguration(proxyBeanMethods = false)
@SpringBootApplication
public class PeopleApplication {

	public static void main(String[] args) {
		SpringApplication.run(PeopleApplication.class, args);
	}

}
