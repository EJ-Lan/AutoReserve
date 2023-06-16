package com.codewithej.car;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CarServiceTest {

    private CarDAO carDAO;
    private CarService carService;

    @BeforeEach
    void setUp() {
        carDAO = new DummyCarDAO(); // Use a dummy implementation of CarDAO for testing
        carService = new CarService(carDAO);
    }

    @Test
    void getAllCars_ShouldReturnListOfAllCars() {
        List<Car> expectedCars = createDummyCarList();

        List<Car> actualCars = carService.getAllCars();

        assertEquals(expectedCars, actualCars);
    }

    @Test
    void getCar_WhenCarExists_ShouldReturnCar() {
        List<Car> cars = createDummyCarList();
        String existingRegNumber = cars.get(0).getRegNumber();

        Car actualCar = carService.getCar(existingRegNumber);

        assertEquals(cars.get(0), actualCar);
    }

    @Test
    void getAllElectricCars_ShouldReturnListOfElectricCars() {
        List<Car> cars = createDummyCarList();

        List<Car> expectedElectricCars = cars.stream()
                .filter(Car::isElectric)
                .toList();

        List<Car> actualElectricCars = carService.getAllElectricCars();

        assertEquals(expectedElectricCars, actualElectricCars);
    }

    private static List<Car> createDummyCarList() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("ABC123", new BigDecimal("89.00"), Brand.AUDI, false));
        cars.add(new Car("XYZ789", new BigDecimal("99.00"), Brand.TESLA, true));
        cars.add(new Car("DEF456", new BigDecimal("29.00"), Brand.MERCEDES, false));
        return cars;
    }

    // Dummy implementation of CarDAO for testing purposes
    private static class DummyCarDAO extends CarDAO {
        private final List<Car> cars;

        public DummyCarDAO() {
            cars = createDummyCarList();
        }

        @Override
        public List<Car> getAllCars() {
            return cars;
        }
    }
}
