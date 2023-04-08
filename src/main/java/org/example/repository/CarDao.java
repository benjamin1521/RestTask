package org.example.repository;

import org.example.model.Car;

import java.util.List;

public interface CarDao {
    List<Car> getAllCars();
    void addCar(Car car);
    Car getCarByModel(String make);
}

