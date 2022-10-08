package com.adbms.team1.HMS.services.impl;

import com.adbms.team1.HMS.Model.Food;
import com.adbms.team1.HMS.repositories.FoodRepository;
import com.adbms.team1.HMS.services.FoodServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class FoodServicesImpl implements FoodServices {

    @Autowired
    private FoodRepository foodRepository;

    @Autowired
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Food> getAllFoods() {
        return foodRepository.getAllFoods();
    }

    @Override
    public String addFood(Food foodData) {
        String msg;
        boolean status = entityManager.createNamedStoredProcedureQuery("addFood").setParameter("fname",foodData.getFoodName()).setParameter("descr",foodData.getDescription()).setParameter("fprice",foodData.getPrice()).setParameter("fimage",foodData.getImage()).setParameter("fcategory",foodData.getFood_category()).execute();
        if (!status) {
            msg = "Added";
        }
        else {
            msg = "Error";
        }
        return msg;
    }

    @Override
    public List<Food> getFoodById(Integer id) {
        return foodRepository.findFoodByDeletedFalse(id);
    }

    @Override
    public String deleteFoodById(Integer id) {
        String msg;
        boolean status = entityManager.createNamedStoredProcedureQuery("deleteFoodById").setParameter("f_id",id).execute();
        if (status) {
            msg = "Error";
        }
        else {
            msg = "Deleted";
        }
        return msg;
    }

    @Override
    public String updateFood(Integer id, Food foodData) {
        String msg;
        boolean status = entityManager.createNamedStoredProcedureQuery("updateFoodById").setParameter("id",id).setParameter("fname",foodData.getFoodName()).setParameter("descr",foodData.getDescription()).setParameter("fprice",foodData.getPrice()).setParameter("fimage",foodData.getImage()).setParameter("fcategory",foodData.getFood_category()).execute();
        if (!status) {
            msg = "Updated";
        }
        else {
            msg = "Error";
        }
        return msg;
    }
}
