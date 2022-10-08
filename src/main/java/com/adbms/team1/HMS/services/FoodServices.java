package com.adbms.team1.HMS.services;

import com.adbms.team1.HMS.Model.Food;

import java.util.List;

public interface FoodServices {

    public List<Food> getAllFoods();

    String addFood(Food foodData);

    List<Food> getFoodById(Integer id);

    String deleteFoodById(Integer id);

    String updateFood(Integer id, Food foodData);
}
