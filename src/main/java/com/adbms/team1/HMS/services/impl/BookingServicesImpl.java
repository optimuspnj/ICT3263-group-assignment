package com.adbms.team1.HMS.services.impl;

import com.adbms.team1.HMS.Model.Booking;
import com.adbms.team1.HMS.repositories.BookingRepository;
import com.adbms.team1.HMS.services.BookingServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date;
import java.util.List;

@Service
public class BookingServicesImpl implements BookingServices {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Booking> getAllBookings() {
        return bookingRepository.getAllBookings();
    }

    @Override
    public List<Booking> getBookingById(Integer id) {
        return bookingRepository.findBookingByDeletedFalse(id);
    }

    @Override
    public String deleteBookingById(Integer id) {
        String msg;
        boolean status =  entityManager.createNamedStoredProcedureQuery("deleteBookingById").setParameter("booking_id",id).execute();
        if (status) {
            msg = "Error";
        }
        else {
            msg = "Deleted";
        }
        return msg;
    }

    @Override
    public String updateBooking(Integer id, Booking bookingData) {
        String msg;
        boolean status =  entityManager.createNamedStoredProcedureQuery("updateBookingById").setParameter("id",id).setParameter("bdate",bookingData.getBookingDate()).setParameter("adate",bookingData.getArrivalDate()).setParameter("ddate",bookingData.getDepartureDate()).setParameter("amount",bookingData.getBookingAmount()).execute();
        if (!status) {
            msg = "Updated";
        }
        else {
            msg = "Error";
        }
        return msg;
    }

    @Override
    public List<Booking> getBookingRange(String start, String end) {
        return bookingRepository.getBookingRange(start, end);
    }

    @Override
    public String addBooking(Booking bookingData) {
        String msg;
        boolean status =  entityManager.createNamedStoredProcedureQuery("addBooking").setParameter("bdate",bookingData.getBookingDate()).setParameter("adate",bookingData.getArrivalDate()).setParameter("ddate",bookingData.getDepartureDate()).setParameter("amount",bookingData.getBookingAmount()).setParameter("cus",bookingData.getCusId()).execute();
        if (!status) {
            msg = "Added";
        }
        else {
            msg = "Error";
        }
        return msg;
   }
}
