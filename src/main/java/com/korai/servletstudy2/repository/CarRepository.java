package com.korai.servletstudy2.repository;

import com.korai.servletstudy2.model.Car;

import java.util.ArrayList;
import java.util.List;

public class CarRepository {
    private static CarRepository instance;
    private int lastId;
    private List<Car> cars;

    private CarRepository() {
        lastId = 1;
        cars = new ArrayList<>();
    }

    public static CarRepository getInstance() {
        if (instance == null) {
            instance = new CarRepository();
        }
        return instance;
    }

    public void insert(Car car) {
        car.setId(lastId++);
        cars.add(car);
    }



    public List<Car> findAll() {
        return cars.stream().map(car -> new Car(car)).toList();
    }


}
