package com.trainingmug.car.car_management_system.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Car name is required")
    private String name;

    @NotBlank(message = "Model is required")
    private String model;

    @Min(value = 1886, message = "Year must be valid (earliest car was invented in 1886)")
    private int year;

    @Min(value = 0, message = "Price must be positive")
    private double price;

    @NotBlank(message = "Color is required")
    private String color;

    @NotBlank(message = "Fuel type is required")
    private String fuelType;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }
    // Constructor for sample data
    public Car(String name, String model, int year, double price, String color, String fuelType) {
        this.name = name;
        this.model = model;
        this.year = year;
        this.price = price;
        this.color = color;
        this.fuelType = fuelType;
    }

    // Default constructor (required for JPA)
    public Car() {
    }

}
