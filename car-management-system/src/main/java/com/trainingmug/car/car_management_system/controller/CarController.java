package com.trainingmug.car.car_management_system.controller;

import com.trainingmug.car.car_management_system.model.Car;
import com.trainingmug.car.car_management_system.service.CarService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cars")
public class CarController {

    @Autowired
    private CarService carService;

    // Create a new car
    @PostMapping
    public ResponseEntity<Car> addCar(@Valid @RequestBody Car car) {
        return new ResponseEntity<>(carService.addCar(car), HttpStatus.CREATED);
    }

    // Get all cars with pagination
    @GetMapping
    public ResponseEntity<Page<Car>> getAllCars(@RequestParam(defaultValue = "0") int page,
                                                @RequestParam(defaultValue = "10") int size) {
        return new ResponseEntity<>(carService.getAllCars(page, size), HttpStatus.OK);
    }

    // Get car by ID
    @GetMapping("/{id}")
    public ResponseEntity<Car> getCarById(@PathVariable Long id) {
        Optional<Car> car = carService.getCarById(id);
        return car.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    //Car Search
    @GetMapping("/search")
    public ResponseEntity<List<Car>> searchCars(@RequestParam String keyword) {
        return new ResponseEntity<>(carService.searchCars(keyword), HttpStatus.OK);
    }


    // Update a car
    @PutMapping("/{id}")
    public ResponseEntity<Car> updateCar(@PathVariable Long id, @Valid @RequestBody Car car) {
        Car updatedCar = carService.updateCar(id, car);
        if (updatedCar != null) {
            return new ResponseEntity<>(updatedCar, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Delete a car
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCar(@PathVariable Long id) {
        carService.deleteCar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    //for sorting
    @GetMapping("/sorted")
    public ResponseEntity<List<Car>> getAllCarsSorted(@RequestParam(defaultValue = "name") String sortBy) {
        return new ResponseEntity<>(carService.getAllCarsSorted(sortBy), HttpStatus.OK);
    }

}
