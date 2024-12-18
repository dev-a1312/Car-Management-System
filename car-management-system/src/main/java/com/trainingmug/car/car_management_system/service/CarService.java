package com.trainingmug.car.car_management_system.service;

import com.trainingmug.car.car_management_system.model.Car;
import com.trainingmug.car.car_management_system.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    // Add a new car
    public Car addCar(Car car) {
        return carRepository.save(car);
    }

    // Get all cars with pagination and sorting
    public Page<Car> getAllCars(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return carRepository.findAll(pageable);
    }

    // Get a car by ID
    public Optional<Car> getCarById(Long id) {
        return carRepository.findById(id);
    }

    // Update a car
    public Car updateCar(Long id, Car updatedCar) {
        Optional<Car> existingCar = carRepository.findById(id);
        if (existingCar.isPresent()) {
            Car car = existingCar.get();
            car.setName(updatedCar.getName());
            car.setModel(updatedCar.getModel());
            car.setYear(updatedCar.getYear());
            car.setPrice(updatedCar.getPrice());
            car.setColor(updatedCar.getColor());
            car.setFuelType(updatedCar.getFuelType());
            return carRepository.save(car);
        }
        return null;
    }

    // Delete a car
    public void deleteCar(Long id) {
        carRepository.deleteById(id);
    }

    //Search a car
    public List<Car> searchCars(String keyword) {
        return carRepository.findByNameContainingIgnoreCaseOrModelContainingIgnoreCaseOrColorContainingIgnoreCaseOrFuelTypeContainingIgnoreCase(
                keyword, keyword, keyword, keyword);
    }

//    Sort Cars
    public List<Car> getAllCarsSorted(String sortBy) {
        return carRepository.findAll(Sort.by(Sort.Direction.ASC, sortBy));
    }

}
