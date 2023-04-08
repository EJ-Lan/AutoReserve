package com.codewithej.booking;


public class BookingService {

    private BookingDAO bookingDAO;

    public BookingService() {
        this.bookingDAO = new BookingDAO();
    }

    public Booking[] getBookings() {
        return bookingDAO.getBookings();
    }
}
