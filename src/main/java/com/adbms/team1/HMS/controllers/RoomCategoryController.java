package com.adbms.team1.HMS.controllers;

import com.adbms.team1.HMS.Model.Room;
import com.adbms.team1.HMS.Model.RoomCategory;
import com.adbms.team1.HMS.services.RoomCategoryServices;
import com.adbms.team1.HMS.services.RoomServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rooms/category")
public class RoomCategoryController {
    @Autowired
    RoomCategoryServices roomCategoryServices;

    @GetMapping("/all")
    public List<RoomCategory> getAllRoomCategories() {
        return roomCategoryServices.getAllRoomCategroies();
    }

    @PostMapping("/add")
    public String addRoomCategory(@RequestBody RoomCategory roomCategoryData) {
        return roomCategoryServices.addRoomCategory(roomCategoryData);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteRoomCategoryById(@PathVariable Integer id) {
        return roomCategoryServices.deleteRoomCategoryById(id);
    }

}
