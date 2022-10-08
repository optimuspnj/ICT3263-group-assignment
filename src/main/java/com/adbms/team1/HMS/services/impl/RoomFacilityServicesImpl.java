package com.adbms.team1.HMS.services.impl;

import com.adbms.team1.HMS.Model.Facility;
import com.adbms.team1.HMS.Model.RoomFacility;
import com.adbms.team1.HMS.repositories.RoomCategoryRepository;
import com.adbms.team1.HMS.repositories.RoomFacilityRepository;
import com.adbms.team1.HMS.services.RoomFacilityServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class RoomFacilityServicesImpl implements RoomFacilityServices {

    @Autowired
    private RoomFacilityRepository roomFacilityRepository;

    @Autowired
    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<Facility> getAllRoomFacilities() {
        return roomFacilityRepository.getAllRoomFacilities();
    }

    @Override
    public String addRoomFacility(Facility roomFacilityData) {
        String msg;
        boolean status =  entityManager.createNamedStoredProcedureQuery("addRoomFacility").setParameter("fac_name",roomFacilityData.getFacName()).setParameter("image",roomFacilityData.getImage()).execute();
        if (!status) {
            msg = "Added";
        }
        else {
            msg = "Error";
        }
        return msg;
    }

    @Override
    public String deleteRoomfacilityById(Integer id) {
        String msg;
        boolean status =  entityManager.createNamedStoredProcedureQuery("deleteRoomFacilityById").setParameter("id",id).execute();
        if (status) {
            msg = "Error";
        }
        else {
            msg = "Deleted";
        }
        return msg;
    }
}
