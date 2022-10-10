package com.adbms.team1.HMS.controllers;

import com.adbms.team1.HMS.Model.Booking;
import com.adbms.team1.HMS.services.BookingServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/bookings")
public class BookingController {
    @Autowired
    private BookingServices bookingServices;

    @GetMapping("/all")
    public List<Booking> getAllBookings() {
        return bookingServices.getAllBookings();
    }

    @PostMapping("/add")
    public String addBooking(@RequestBody Booking bookingData) {
        return bookingServices.addBooking(bookingData);
    }

    @GetMapping("/booking/{id}")
    public List<Booking> getBookingById(@PathVariable Integer id) {
        return bookingServices.getBookingById(id);
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @PutMapping("/delete/{id}")
    public String deleteBookingById(@PathVariable Integer id) {
        return bookingServices.deleteBookingById(id);
    }

    @PutMapping("/update/{id}")
    public String updateBookingById(@PathVariable Integer id, @RequestBody Booking bookingData) {
        return bookingServices.updateBooking(id,bookingData);
    }

    @GetMapping("/bookingRange/{start}_{end}")
    public List<Booking> getBookingRange(@PathVariable String start, @PathVariable String end) {
        return bookingServices.getBookingRange(start, end);
    }
}