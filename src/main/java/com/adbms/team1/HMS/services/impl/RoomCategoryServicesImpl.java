package com.adbms.team1.HMS.services.impl;

import com.adbms.team1.HMS.Model.RoomCategory;
import com.adbms.team1.HMS.repositories.RoomCategoryRepository;
import com.adbms.team1.HMS.repositories.RoomRepository;
import com.adbms.team1.HMS.services.RoomCategoryServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class RoomCategoryServicesImpl implements RoomCategoryServices {

    @Autowired
    private RoomCategoryRepository roomCategoryRepository;


    @Autowired
    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<RoomCategory> getAllRoomCategroies() {
        return roomCategoryRepository.getAllRoomCategories();
    }

    @Override
    public String addRoomCategory(RoomCategory roomCategoryData) {
        String msg;
        boolean status =  entityManager.createNamedStoredProcedureQuery("addRoomCategory").setParameter("cat_name",roomCategoryData.getCatName()).setParameter("cat_image",roomCategoryData.getCatImage()).execute();
        if (!status) {
            msg = "Added";
        }
        else {
            msg = "Error";
        }
        return msg;
    }

    @Override
    public String deleteRoomCategoryById(Integer id) {
        String msg;
        boolean status =  entityManager.createNamedStoredProcedureQuery("deleteRoomCategoryById").setParameter("id",id).execute();
        if (status) {
            msg = "Error";
        }
        else {
            msg = "Deleted";
        }
        return msg;
    }
}
