package com.adbms.team1.HMS.services;

import com.adbms.team1.HMS.Model.Booking;

import java.util.List;

public interface BookingServices {
    List<Booking> getAllBookings();

    String addBooking(Booking bookingData);

    List<Booking> getBookingById(Integer id);

    String deleteBookingById(Integer id);

    String updateBooking(Integer id, Booking bookingData);
}
