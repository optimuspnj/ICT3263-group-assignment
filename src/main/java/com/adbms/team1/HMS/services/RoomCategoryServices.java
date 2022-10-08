package com.adbms.team1.HMS.services;

import com.adbms.team1.HMS.Model.Room;
import com.adbms.team1.HMS.Model.RoomCategory;

import java.util.List;

public interface RoomCategoryServices {
    List<RoomCategory> getAllRoomCategroies();
    String addRoomCategory(RoomCategory roomCategoryData);
    String deleteRoomCategoryById(Integer id);

}
