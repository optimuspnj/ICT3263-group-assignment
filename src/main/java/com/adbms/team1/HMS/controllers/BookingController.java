package com.adbms.team1.HMS.controllers;

import com.adbms.team1.HMS.Model.Booking;
import com.adbms.team1.HMS.services.BookingServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/booking")
public class BookingController {
    @Autowired
    private BookingServices bookingServices;

    @GetMapping("/all")
    public List<Booking> getAllBookings() {
        return bookingServices.getAllBookings();
    }

    @GetMapping("/id/{id}")
    public List<Booking> getBookingById(@PathVariable Integer id) {
        return (List<Booking>) bookingServices.getBookingById(id);
    }

    @PutMapping("/delete/{id}")
    public String deleteBookingById(@PathVariable Integer id) {
        return bookingServices.deleteBookingById(id);
    }

    @PostMapping("/new")
    public String addBooking(@RequestBody Booking bookingData) {
        return bookingServices.addBooking(bookingData);
    }
}