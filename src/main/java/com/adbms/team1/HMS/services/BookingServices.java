package com.adbms.team1.HMS.services;

import com.adbms.team1.HMS.Model.Booking;

import java.util.List;

public interface BookingServices {
    List<Booking> getAllBookings();

    List<Booking> getBookingById(Integer id);

    String deleteBookingById(Integer id);

    String addBooking(Booking bookingData);
}
