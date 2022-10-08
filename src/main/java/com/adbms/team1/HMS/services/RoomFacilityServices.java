package com.adbms.team1.HMS.services;

import com.adbms.team1.HMS.Model.Facility;
import com.adbms.team1.HMS.Model.RoomCategory;
import com.adbms.team1.HMS.Model.RoomFacility;

import java.util.List;

public interface RoomFacilityServices {
    List<Facility> getAllRoomFacilities();
    String addRoomFacility(Facility roomFacilityData);
    String deleteRoomfacilityById(Integer id);
}
