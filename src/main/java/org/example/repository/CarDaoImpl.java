package org.example.repository;

import org.example.model.Car;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class CarDaoImpl implements CarDao {
    private final List<Car> cars;

    public CarDaoImpl() {
        Car volvo = new Car("Volvo");
        Car audi = new Car("Audi");
        Car toyota = new Car("Toyota");
        Car honda = new Car("Honda");

        cars = Arrays.asList(volvo, audi, toyota, honda);
    }

    @Override
    public List<Car> getAllCars() {
        return cars;
    }

    @Override
    public void addCar(Car car) {
        cars.add(car);
    }

    @Override
    public Car getCarByModel(String model) {
        return cars.stream()
                .filter(car -> car.getModel().equals(model))
                .findFirst()
                .orElse(null);
    }
}
