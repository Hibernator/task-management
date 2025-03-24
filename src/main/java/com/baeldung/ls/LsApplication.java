package com.baeldung.ls;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.baeldung.ls")
public class LsApplication {

	public static void main(String[] args) {
		SpringApplication.run(LsApplication.class, args);
	}

}
