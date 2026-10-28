package com.korai.servletstudy2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Car {
    private int id;
    private String carNumber;
    private String time;

    public Car(Car other) {
        this.id = other.id;
        this.carNumber = other.carNumber;
        this.time = other.time;
    }
}


