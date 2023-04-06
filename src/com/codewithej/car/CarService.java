package com.codewithej.car;

public class CarService {

    private CarDAO carDAO;

    public CarService() {
        this.carDAO = new CarDAO();
    }

    public Car[] getCars() {
        return carDAO.getCars();
    }
}
