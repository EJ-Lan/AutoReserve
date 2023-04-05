package com.codewithej.booking;

import com.codewithej.car.Car;
import com.codewithej.user.User;

import java.time.LocalTime;
import java.util.Objects;
import java.util.UUID;

public class Booking {
    private User user;
    private Car car;
    private boolean isCanceled;
    private UUID bookingID;
    private LocalTime bookingTime;

    public Booking(User user, Car car, boolean isCanceled, UUID bookingID, LocalTime bookingTime) {
        this.user = user;
        this.car = car;
        this.isCanceled = isCanceled;
        this.bookingID = bookingID;
        this.bookingTime = bookingTime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public boolean isCanceled() {
        return isCanceled;
    }

    public void setCanceled(boolean canceled) {
        isCanceled = canceled;
    }

    public UUID getBookingID() {
        return bookingID;
    }

    public void setBookingID(UUID bookingID) {
        this.bookingID = bookingID;
    }

    public LocalTime getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(LocalTime bookingTime) {
        this.bookingTime = bookingTime;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "user=" + user +
                ", car=" + car +
                ", isCanceled=" + isCanceled +
                ", bookingID=" + bookingID +
                ", bookingTime=" + bookingTime +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Booking booking = (Booking) o;
        return isCanceled == booking.isCanceled && Objects.equals(user, booking.user) && Objects.equals(car, booking.car) && Objects.equals(bookingID, booking.bookingID) && Objects.equals(bookingTime, booking.bookingTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, car, isCanceled, bookingID, bookingTime);
    }
}
