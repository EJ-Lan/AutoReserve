package com.codewithej.booking;

public class BookingDao {
    private static Booking[] bookings;
    private static int nextAvailableSlot = 0;

    private static final int CAPACITY = 100;

    static {
        bookings = new Booking[CAPACITY];
    }

    public void saveBooking(Booking booking) {
        if (nextAvailableSlot >= CAPACITY) {
            int newCapacity = CAPACITY * 2;
            Booking[] newBookings = new Booking[newCapacity];
            System.arraycopy(bookings, 0, newBookings, 0, CAPACITY);
            bookings = newBookings;
        }
        bookings[nextAvailableSlot++] = booking;
    }


    public Booking[] getBookings() {
        return bookings;
    }
}
