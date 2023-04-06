package com.codewithej.car;

import java.math.BigDecimal;

public class CarDAO {

    private static final Car[] cars;

    static {
        cars = new Car[] {
                new Car(12324, new BigDecimal("100"),Brand.MERCEDES,false),
                new Car(1254, new BigDecimal("120"), Brand.AUDI, false),
                new Car(514, new BigDecimal("200"), Brand.TESLA, true),
                new Car (15, new BigDecimal("90"), Brand.BMW, false)
        };
    }


    public Car[] getCars() {

        return cars;
    }
}
