package com.adbms.team1.HMS.services;

import com.adbms.team1.HMS.Model.Booking;
import com.adbms.team1.HMS.Model.Room;

import java.util.List;

public interface RoomServices {

    List<Room> getAllRooms();

    String addRoom(Room roomData);

    List<Room> getRoomById(Integer id);

    String deleteRoomById(Integer id);

    String updateRoom(Integer id, Room roomData);

}
