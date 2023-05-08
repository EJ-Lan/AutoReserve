package com.codewithej.booking;

import java.util.ArrayList;
import java.util.List;

public class CarBookingDao {

    private final static List<CarBooking> carBookings;

    static {
        carBookings = new ArrayList<CarBooking>();
    }

    public List<CarBooking> getCarBookings() {
        return carBookings;
    }

    public void book(CarBooking carBooking) {
        carBookings.add(carBooking);

    }


}
