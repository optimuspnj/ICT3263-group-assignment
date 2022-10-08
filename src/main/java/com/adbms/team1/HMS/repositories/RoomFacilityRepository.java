package com.adbms.team1.HMS.repositories;

import com.adbms.team1.HMS.Model.Facility;
import com.adbms.team1.HMS.Model.RoomCategory;
import com.adbms.team1.HMS.Model.RoomFacility;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RoomFacilityRepository extends JpaRepository<Facility,Integer> {
    @Query(value="call hoteldb.getAllRoomFacilities();", nativeQuery=true)
    List<Facility> getAllRoomFacilities();
}
