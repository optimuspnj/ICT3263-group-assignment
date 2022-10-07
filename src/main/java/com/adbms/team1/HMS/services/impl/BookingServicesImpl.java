package com.adbms.team1.HMS.services.impl;

import com.adbms.team1.HMS.Model.Booking;
import com.adbms.team1.HMS.repositories.BookingRepository;
import com.adbms.team1.HMS.services.BookingServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class BookingServicesImpl implements BookingServices {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    @PersistenceContext
    private EntityManager entityManager;

    public List<Booking> getAllBookings(){
        return entityManager.createNamedStoredProcedureQuery("getAllBookings").getResultList();
    }

    @Override
    public List<Booking> getBookingById(Integer id) {
        return (List<Booking>) entityManager.createNamedStoredProcedureQuery("getBookingById").setParameter("booking_id",id).getResultList();
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
    public String addBooking(Booking bookingData) {
        String msg;
        //Customer ID hardcoded
        boolean status =  entityManager.createNamedStoredProcedureQuery("deleteBookingById").setParameter("bdate",bookingData.getBookingDate()).setParameter("adate",bookingData.getArrivalDate()).setParameter("ddate",bookingData.getDepartureDate()).setParameter("amount",bookingData.getBookingAmount()).setParameter("cus",2).execute();
        if (status) {
            msg = "Error";
        }
        else {
            msg = "Deleted";
        }
        return msg;
    }
}
