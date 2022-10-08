package com.adbms.team1.HMS.controllers;

import com.adbms.team1.HMS.Model.Facility;
import com.adbms.team1.HMS.Model.RoomCategory;
import com.adbms.team1.HMS.services.RoomCategoryServices;
import com.adbms.team1.HMS.services.RoomFacilityServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rooms/facility")
public class RoomFacilityController {

    @Autowired
    RoomFacilityServices roomFacilityServices;

    @GetMapping("/all")
    public List<Facility> getAllRoomFacilities() {
        return roomFacilityServices.getAllRoomFacilities();
    }

    @PostMapping("/add")
    public String addRoomFacility(@RequestBody Facility roomFacilityData) {
        return roomFacilityServices.addRoomFacility(roomFacilityData);
    }

    @PutMapping("/delete/{id}")
    public String deleteRoomFacilityById(@PathVariable Integer id) {
        return roomFacilityServices.deleteRoomfacilityById(id);
    }
}
