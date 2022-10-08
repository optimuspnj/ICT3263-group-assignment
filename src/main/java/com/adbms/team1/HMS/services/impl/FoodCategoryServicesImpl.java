package com.adbms.team1.HMS.services.impl;

import com.adbms.team1.HMS.Model.FoodCategory;
import com.adbms.team1.HMS.repositories.FoodCategoryRepository;
import com.adbms.team1.HMS.services.FoodCategoryServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class FoodCategoryServicesImpl implements FoodCategoryServices {

    @Autowired
    private FoodCategoryRepository foodCategoryRepository;

    @Autowired
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<FoodCategory> getAllFoodCategory() {
        return foodCategoryRepository.getAllFoodCategory();
    }

    @Override
    public String addFoodCategory(FoodCategory foodCategoryData) {
        String msg;
        boolean status = entityManager.createNamedStoredProcedureQuery("addFoodCategory").setParameter("f_category",foodCategoryData.getFcName()).execute();
        if (!status) {
            msg = "Added";
        }
        else {
            msg = "Error";
        }
        return msg;
    }

    @Override
    public String deleteFoodCategoryById(Integer id) {
        String msg;
        boolean status = entityManager.createNamedStoredProcedureQuery("deleteFoodCategoryById").setParameter("id",id).execute();
        if (status) {
            msg = "Error";
        }
        else {
            msg = "Deleted";
        }
        return msg;
    }
}
