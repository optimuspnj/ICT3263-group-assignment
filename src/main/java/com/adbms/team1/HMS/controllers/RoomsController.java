package com.adbms.team1.HMS.controllers;

import com.adbms.team1.HMS.Model.Booking;
import com.adbms.team1.HMS.Model.Room;
import com.adbms.team1.HMS.services.RoomServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rooms")
public class RoomsController {

    @Autowired
    RoomServices roomServices;

    @GetMapping("/all")
    public List<Room> getAllRooms() {
        return roomServices.getAllRooms();
    }


    @PostMapping("/add")
    public String addRoom(@RequestBody Room roomData) {
        return roomServices.addRoom(roomData);
    }

    @GetMapping("/room/{id}")
    public List<Room> getRoomById(@PathVariable Integer id) {
        return roomServices.getRoomById(id);
    }

    @PutMapping("/delete/{id}")
    public String deleteRoomById(@PathVariable Integer id) {
        return roomServices.deleteRoomById(id);
    }

    @PutMapping("/update/{id}")
    public String updateBookingById(@PathVariable Integer id, @RequestBody Room roomData) {
        return roomServices.updateRoom(id,roomData);
    }


}
