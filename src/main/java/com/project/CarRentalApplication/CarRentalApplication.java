package com.project.CarRentalApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class CarRentalApplication {

	public static void main(String[] args) {

		SpringApplication.run(CarRentalApplication.class, args);
		System.out.println("application started");
	}

}
