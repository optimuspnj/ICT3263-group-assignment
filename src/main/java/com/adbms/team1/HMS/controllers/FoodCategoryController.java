package com.adbms.team1.HMS.controllers;

import com.adbms.team1.HMS.Model.FoodCategory;
import com.adbms.team1.HMS.services.FoodCategoryServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/foodscategory")
public class FoodCategoryController {

    @Autowired
    private FoodCategoryServices foodCategoryServices;

    @GetMapping("/all")
    public List<FoodCategory> getAllFoodCategory() {
        return foodCategoryServices.getAllFoodCategory();
    }

    @PostMapping("/add")
    public String addFoodCategory(@RequestBody FoodCategory foodCategoryData) {
        return foodCategoryServices.addFoodCategory(foodCategoryData);
    }

    @PutMapping("/delete/{id}")
    public String deleteFoodCategoryById(@PathVariable Integer id) {
        return foodCategoryServices.deleteFoodCategoryById(id);
    }
}
