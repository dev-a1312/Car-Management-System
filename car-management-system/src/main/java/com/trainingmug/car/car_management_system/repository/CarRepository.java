package com.trainingmug.car.car_management_system.repository;

import com.trainingmug.car.car_management_system.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
    List<Car> findByNameContainingIgnoreCaseOrModelContainingIgnoreCaseOrColorContainingIgnoreCaseOrFuelTypeContainingIgnoreCase(
            String name, String model, String color, String fuelType);
}



