package com.adbms.team1.HMS.services;

import com.adbms.team1.HMS.Model.FoodOrder;

import java.util.List;

public interface FoodOrderServices {

    List<FoodOrder> getAllFoodOrders();

    List<FoodOrder> getFoodOrdersById(Integer id);

    String deleteFoodOrderById(Integer id);


    String updateFoodOrderById(Integer id, FoodOrder foodOrderData);

    String addFoodOrder(FoodOrder foodOrderData);
}
