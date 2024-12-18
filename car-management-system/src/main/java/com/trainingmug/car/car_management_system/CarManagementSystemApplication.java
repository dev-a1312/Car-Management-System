package com.trainingmug.car.car_management_system;

import com.trainingmug.car.car_management_system.model.Car;
import com.trainingmug.car.car_management_system.repository.CarRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CarManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarManagementSystemApplication.class, args);
	}
}
