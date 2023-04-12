package com.codewithej.car;

import com.codewithej.booking.Booking;

public class CarService {

    private final CarDAO carDao;

    public CarService(CarDAO carDao) {
        this.carDao = carDao;
    }

    public Car[] getCars() {
        return carDao.getCars();
    }

    public void removeCar(Booking booking) {
        Car[] cars = carDao.getCars();

        for (int i = 0; i < cars.length; i++) {
            if (cars[i].equals(booking.getCar())) {
                cars[i] = null;
                break;
            }
        }
    }
}
