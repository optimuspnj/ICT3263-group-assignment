package com.adbms.team1.HMS.services;

import com.adbms.team1.HMS.Model.FoodCategory;

import java.util.List;

public interface FoodCategoryServices {
    List<FoodCategory> getAllFoodCategory();

    String addFoodCategory(FoodCategory foodCategoryData);

    String deleteFoodCategoryById(Integer id);
}
