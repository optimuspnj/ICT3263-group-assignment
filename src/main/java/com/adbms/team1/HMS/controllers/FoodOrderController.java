package com.adbms.team1.HMS.controllers;

import com.adbms.team1.HMS.Model.Booking;
import com.adbms.team1.HMS.Model.FoodOrder;
import com.adbms.team1.HMS.services.FoodOrderServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/orders")
public class FoodOrderController {

    @Autowired
    private FoodOrderServices foodorderServices;

    @GetMapping("/all")
    public List<FoodOrder> getAllFoodOrders() {
        return foodorderServices.getAllFoodOrders();
    }

    @GetMapping("/order/{id}")
    public List<FoodOrder> getFoodOrderById(@PathVariable Integer id) {
        return foodorderServices.getFoodOrdersById(id);
    }

    @PutMapping("/delete/{id}")
    public String deleteFoodOrderById(@PathVariable Integer id) {
        return foodorderServices.deleteFoodOrderById(id);
    }

    @PutMapping("/update/{id}")
    public String updateFoodOrderById(@PathVariable Integer id, @RequestBody FoodOrder foodOrderData) {
        return foodorderServices.updateFoodOrderById(id,foodOrderData);
    }

    @PostMapping("/add")
    public String addFoodOrder(@RequestBody FoodOrder foodOrderData) {
        return foodorderServices.addFoodOrder(foodOrderData);
    }


}
