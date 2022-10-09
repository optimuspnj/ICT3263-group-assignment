package com.adbms.team1.HMS.controllers;


import com.adbms.team1.HMS.Model.Food;
import com.adbms.team1.HMS.services.FoodServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/foods")
public class FoodController {

    @Autowired
    private FoodServices foodServices;

    @GetMapping("/all")
    public List<Food> getAllFoods() {
        return foodServices.getAllFoods();
    }

    @PostMapping("/add")
    public String addFood(@RequestBody Food foodData) {
        return foodServices.addFood(foodData);
    }

    @GetMapping("/food/{id}")
    public List<Food> getFoodById(@PathVariable Integer id) {
        return foodServices.getFoodById(id);
    }

    @PutMapping("/delete/{id}")
    public String deleteFoodById(@PathVariable Integer id) {
        return foodServices.deleteFoodById(id);
    }

    @PutMapping("/update/{id}")
    public String updateFoodById(@PathVariable Integer id, @RequestBody Food FoodData) {
        return foodServices.updateFood(id,FoodData);
    }
}
