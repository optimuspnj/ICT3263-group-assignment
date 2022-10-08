package com.adbms.team1.HMS.repositories;

import com.adbms.team1.HMS.Model.Booking;
import com.adbms.team1.HMS.Model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RoomRepository extends JpaRepository<Room,Integer> {

    @Query(value="call hoteldb.getAllRooms();", nativeQuery=true)
    List<Room> getAllRooms();

    @Query(value="call hoteldb.getRoomById(:id);", nativeQuery=true)
    List<Room> findRoomByDeletedFalse(Integer id);
}
