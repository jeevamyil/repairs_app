package com.repairs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({ "com.repairs", "com.repairs.controller", "com.repairs.model", "com.repairs.service",
		"com.repairs.Dao" })
public class RepairsApplication {

	public static void main(String[] args) {
		SpringApplication.run(RepairsApplication.class, args);
	}

}
