package com.codewithej;

import com.codewithej.booking.Booking;
import com.codewithej.booking.BookingService;
import com.codewithej.car.Car;
import com.codewithej.car.CarService;
import com.codewithej.user.User;
import com.codewithej.user.UserService;

import java.util.Scanner;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BookingService bookingService = new BookingService();
        CarService carService = new CarService();
        UserService userService = new UserService();

        displayMenu();
        System.out.println();

        int input = Integer.valueOf(scanner.nextLine());
        cliAction(input, bookingService, carService, userService, scanner);

    }

    private static void cliAction(int input, BookingService bookingService, CarService carService,UserService userService, Scanner scanner) {
        while (input != 7) {
            switch (input) {
                case 1:
                    // Book Car
                    bookNewCar(bookingService, userService, carService, scanner);
                    break;
                case 2:
                    // View All User Booked Cars
                    viewAllUserBookedCars(bookingService, userService, scanner);
                    break;
                case 3:
                    // View All Bookings
                    viewAllBookings(bookingService);
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

            Scanner scan = new Scanner(System.in);
            input = Integer.valueOf(scan.nextLine());
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
            if (car != null) {
                System.out.println(car.toString());
            }
        }
    }

    private static void viewAllElectricCars(CarService carService) {
        Car[] cars = carService.getCars();

        boolean found = false;

        for (Car car: cars) {
            if (car != null) {
                if (car.getElectric()) {
                    System.out.println(car.toString());
                    found = true;
                }
            }
        }

        if (!found) {
            System.out.println("No electric cars");
        }
    }

    private static void viewAllBookings(BookingService bookingService) {
        Booking[] bookings = bookingService.getBookings();

        boolean found = false;

        for (Booking booking : bookings) {
            if (booking == null) {
                continue;
            } else {
                System.out.println(booking.toString());
                found = true;
            }
        }

        if (!found) {
            System.out.println("No bookings available");
        }

    }

    private static void viewAllUserBookedCars(BookingService bookingService, UserService userService, Scanner scanner) {
        viewAllUsers(userService);
        System.out.println("Choose user ID");
        String id = scanner.nextLine();

        User[] users = userService.getUsers();
        User curUser = null;

        for (User user : users) {
            if (user.getId().toString().equals(id)) {
                curUser = user;
            }
        }

        if (curUser == null) {
            System.out.println("User not found");
            return;
        }

        Booking[] bookings = bookingService.searchBookingByUser(curUser);

        if (bookings == null) {
            System.out.println("user " + curUser + " has no bookings");
        } else {
            for (Booking booking : bookings) {
                if (booking != null) {
                    System.out.println(booking.toString());
                }
            }
        }
    }

    private static void bookNewCar(BookingService bookingService, UserService userService, CarService carService, Scanner scanner) {
        viewAllCars(carService);
        System.out.println("Select a reg number");
        String regNum = scanner.nextLine();

        Car[] cars = carService.getCars();
        Car curCar = null;

        for (Car car : cars) {
            if (car.getRegNumber().equals(regNum)) {
                curCar = car;
            }
        }

        if (curCar == null) {
            System.out.println("Car not found");
            return;
        }

        viewAllUsers(userService);
        System.out.println("Choose user ID");
        String id = scanner.nextLine();

        User[] users = userService.getUsers();
        User curUser = null;

        for (User user : users) {
            if (user.getId().toString().equals(id)) {
                curUser = user;
            }
        }

        if (curUser == null) {
            System.out.println("User not found");
            return;
        }

        UUID bookingRef = UUID.randomUUID();

        int result = bookingService.registerNewBooking(bookingRef, curUser, curCar);

        if (result > 0) {
            System.out.println("Successfully booked car with reg number " + curCar.getRegNumber() + " for user " + curUser.toString());
        } else {
            System.out.println("Booking Failed");
        }
    }

}