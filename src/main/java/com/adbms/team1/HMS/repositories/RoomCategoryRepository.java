package com.adbms.team1.HMS.repositories;

import com.adbms.team1.HMS.Model.Booking;
import com.adbms.team1.HMS.Model.Room;
import com.adbms.team1.HMS.Model.RoomCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RoomCategoryRepository extends JpaRepository<RoomCategory,Integer> {
    @Query(value="call hoteldb.getAllRoomCategories();", nativeQuery=true)
    List<RoomCategory> getAllRoomCategories();
}
