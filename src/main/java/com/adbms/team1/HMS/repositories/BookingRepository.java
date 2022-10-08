package com.adbms.team1.HMS.repositories;

import com.adbms.team1.HMS.Model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking,Integer> {
}
