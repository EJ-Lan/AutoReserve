package com.codewithej;

import com.codewithej.booking.BookingService;
import com.codewithej.car.Car;
import com.codewithej.car.CarService;
import com.codewithej.user.User;
import com.codewithej.user.UserService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BookingService bookingService = new BookingService();
        CarService carService = new CarService();
        UserService userService = new UserService();

        displayMenu();
        System.out.println();

        int input = Integer.valueOf(scanner.nextLine());
        cliAction(input, bookingService, carService, userService);

    }

    private static void cliAction(int input, BookingService bookingService, CarService carService,UserService userService) {
        while (input != 7) {
            switch (input) {
                case 1:
                    // Book Car
                    break;
                case 2:
                    // View All User Booked Cars
                    break;
                case 3:
                    // View All Bookings
                    break;
                case 4:
                    // View Available Cars
                    viewAllCars(carService);
                    break;
                case 5:
                    // View Available Electric Cars
                    viewAllElectricCars(carService);
                    break;
                case 6:
                    // View all users
                    viewAllUsers(userService);
                    break;
                case 7:
                    // Exit
                    break;
                default:
                    System.out.println(input + " not a valid option");
            }

            if (input != 7) {
                System.out.println();
                displayMenu();
                System.out.println();
            }

            Scanner scanner = new Scanner(System.in);
            input = Integer.valueOf(scanner.nextLine());
        }
    }

    private static void displayMenu() {
        System.out.println("1 - Book Car");
        System.out.println("2 - View All User Booked Cars");
        System.out.println("3 - View All Bookings");
        System.out.println("4 - View Available Cars");
        System.out.println("5 - View Available Electric Cars");
        System.out.println("6 - View All Users");
        System.out.println("7 - Exit");
    }

    private static void viewAllUsers(UserService userService) {
        User[] users = userService.getUsers();

        for (User user: users) {
            System.out.println(user.toString());
        }
    }

    private static void viewAllCars(CarService carService) {
        Car[] cars = carService.getCars();

        for (Car car: cars) {
            System.out.println(car.toString());
        }
    }

    private static void viewAllElectricCars(CarService carService) {
        Car[] cars = carService.getCars();

        boolean found = false;

        for (Car car: cars) {
            if (car.getElectric()) {
                System.out.println(car.toString());
                found = true;
            }
        }

        if (!found) {
            System.out.println("No electric cars");
        }
    }

}