package com.adbms.team1.HMS.repositories;

import com.adbms.team1.HMS.Model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface BookingRepository extends JpaRepository<Booking,Integer> {
    @Query(value="call hoteldb.getAllBookings();", nativeQuery=true)
    List<Booking> getAllBookings();
    @Query(value="call hoteldb.getBookingById(:id);", nativeQuery=true)
    List<Booking> findBookingByDeletedFalse(Integer id);
    @Query(value="call hoteldb.getBookingsByDateRange(:start,:end);", nativeQuery=true)
    List<Booking> getBookingRange(String start, String end);
}
