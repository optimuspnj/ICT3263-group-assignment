package com.adbms.team1.HMS.repositories;

import com.adbms.team1.HMS.Model.Booking;
import com.adbms.team1.HMS.Model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message,Integer> {
    @Query(value="call hoteldb.getAllMessages();", nativeQuery=true)
    List<Message> getAllMessages();
}
