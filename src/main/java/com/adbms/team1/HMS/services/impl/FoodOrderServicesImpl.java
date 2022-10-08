package com.adbms.team1.HMS.services.impl;

import com.adbms.team1.HMS.Model.FoodOrder;

import com.adbms.team1.HMS.repositories.FoodOrderRepository;
import com.adbms.team1.HMS.services.FoodOrderServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
@Service
public class FoodOrderServicesImpl implements FoodOrderServices {
    @Autowired
    private FoodOrderRepository foodOrderRepository;

    @Autowired
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<FoodOrder> getAllFoodOrders() {
        return foodOrderRepository.getAllFoodOrder();
    }

    @Override
    public List<FoodOrder> getFoodOrdersById(Integer id) {
        return foodOrderRepository.getFoodOrdersById(id);
    }

    @Override
    public String deleteFoodOrderById(Integer id) {
        String msg;
        boolean status =  entityManager.createNamedStoredProcedureQuery("deleteFoodOrderById").setParameter("fo_id",id).execute();
        if (status) {
            msg = "Error";
        }
        else {
            msg = "Deleted";
        }
        return msg;
    }

    @Override
    public String updateFoodOrderById(Integer id, FoodOrder foodOrderData) {
        String msg;
        boolean status =  entityManager.createNamedStoredProcedureQuery("updateFoodOrderById").setParameter("fo_id",id).setParameter("date",foodOrderData.getDate()).setParameter("total_payment",foodOrderData.getTotalPayment()).execute();
        if (!status) {
            msg = "Updated";
        }
        else {
            msg = "Error";
        }
        return msg;

    }

    @Override
    public String addFoodOrder(FoodOrder foodOrderData) {
        String msg;
        boolean status =  entityManager.createNamedStoredProcedureQuery("addFoodOrder").setParameter("date",foodOrderData.getDate()).setParameter("cus_id",foodOrderData.getCus_id()).setParameter("total_payment",foodOrderData.getTotalPayment()).execute();
        if (!status) {
            msg = "Added";
        }
        else {
            msg = "Error";
        }
        return msg;
    }


}
