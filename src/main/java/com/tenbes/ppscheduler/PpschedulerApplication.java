package com.tenbes.ppscheduler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages="com.tenbes") // comment this out to test postman > backend again!!
public class PpschedulerApplication {

	public static void main(String[] args) {
		SpringApplication.run(PpschedulerApplication.class, args);
	}

}
