package com.codewithej.car;

import com.codewithej.booking.Booking;

public class CarService {

    private CarDao carDAO;

    public CarService() {
        this.carDAO = new CarDao();
    }

    public Car[] getCars() {
        return carDAO.getCars();
    }

    public void removeCar(Booking booking) {
        Car[] cars = carDAO.getCars();

        for (int i = 0; i < cars.length; i++) {
            if (cars[i].equals(booking.getCar())) {
                cars[i] = null;
                break;
            }
        }
    }
}
