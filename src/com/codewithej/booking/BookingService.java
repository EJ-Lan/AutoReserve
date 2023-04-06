package com.codewithej.booking;

import com.codewithej.user.User;

public class BookingService {

    private BookingDAO bookingDAO;

    public BookingService() {
        this.bookingDAO = new BookingDAO();
    }

    public int registerNewBooking(Booking booking) {
        if (booking == null) {
            return -1;
        }

        if (booking.isCanceled()) {
            return -2;
        }

        if (booking.getCar() == null) {
            return -3;
        }

        if (booking.getUser() == null) {
            return -4;
        }

        bookingDAO.saveBooking(booking);
        return 1;
    }

    public Booking[] getBookings() {
        return bookingDAO.selectAllBookings();
    }

    public Booking[] selectBookingByUser(User user) {
        Booking[] bookings = bookingDAO.selectAllBookings();
        Booking[] result = new Booking[bookings.length];
        int count = 0;

        for (int i = 0; i < bookings.length; i++) {
            if (bookings[i].getUser().equals(user)) {
                result[count++] = bookings[i];
            }
        }

        if (count == 0) {
            return new Booking[0];
        } else {
            Booking[] finalResult = new Booking[count];
            System.arraycopy(result, 0, finalResult, 0, count);
            return finalResult;
        }
    }
}
