package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class Contact {
    private String name;
    private List<Car> cars;
    public void addCar(Car car) {
        cars.add(car);
    }

}
