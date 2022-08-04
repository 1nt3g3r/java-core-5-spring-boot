package com.goit5.testapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class JavaCoreTestAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaCoreTestAppApplication.class, args);
	}

}
