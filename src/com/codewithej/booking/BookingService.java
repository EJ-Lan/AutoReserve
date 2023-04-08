package com.codewithej.booking;


import com.codewithej.car.Car;
import com.codewithej.user.User;

import java.util.Arrays;
import java.util.UUID;

public class BookingService {

    private BookingDAO bookingDAO;

    public BookingService() {
        this.bookingDAO = new BookingDAO();
    }

    public Booking[] getBookings() {
        return bookingDAO.getBookings();
    }

    public int registerNewBooking(UUID bookingRef, User user, Car car) {
        Booking booking = new Booking(bookingRef, user, car);
        bookingDAO.saveBooking(booking);
        return 1;
    }

    public Booking[] searchBookingByUser(User user) {
        Booking[] bookings = bookingDAO.getBookings();
        Booking[] userBookings = new Booking[bookings.length];
        int index = 0;

        for (Booking booking : bookings) {
            if (booking != null) {
                if (booking.getUser().equals(user)) {
                    userBookings[index++] = booking;
                }
            }
        }

        if (index == 0) {
            return new Booking[0];
        } else {
            return Arrays.copyOfRange(userBookings, 0, index);
        }
    }
}
