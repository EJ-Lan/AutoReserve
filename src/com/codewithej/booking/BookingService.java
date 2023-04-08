package com.codewithej.booking;


import com.codewithej.car.Car;
import com.codewithej.car.CarService;
import com.codewithej.user.User;

import java.util.UUID;

public class BookingService {

    private BookingDAO bookingDAO;
    private CarService carService;

    public BookingService() {
        this.bookingDAO = new BookingDAO();
        this.carService = new CarService();
    }

    public Booking[] getBookings() {
        return bookingDAO.getBookings();
    }

    public void registerNewBooking(UUID bookingRef, User user, Car car) {
        Booking booking = new Booking(bookingRef, user, car);
        bookingDAO.saveBooking(booking);
        carService.removeCar(booking);
        System.out.println("Successfully booked car with reg number " + car.getRegNumber() + " for user " + user.toString());
    }

    public void searchBookingByUser(User user) {
        Booking[] bookings = bookingDAO.getBookings();

        boolean found = false;

        for (Booking booking : bookings) {
            if (booking != null) {
                if (booking.getUser().equals(user)) {
                    System.out.println(booking.toString());
                    found = true;
                }
            }
        }

        if (!found) {
            System.out.println("user " + user + " has no bookings");
        }
    }
}
