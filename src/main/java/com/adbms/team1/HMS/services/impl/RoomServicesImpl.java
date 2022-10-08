package com.adbms.team1.HMS.services.impl;

import com.adbms.team1.HMS.Model.Room;
import com.adbms.team1.HMS.repositories.BookingRepository;
import com.adbms.team1.HMS.repositories.RoomRepository;
import com.adbms.team1.HMS.services.RoomServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class RoomServicesImpl implements RoomServices {

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Room> getAllRooms() {
        return roomRepository.getAllRooms();
    }

    @Override
    public String addRoom(Room roomData) {
        String msg;
        boolean status =  entityManager.createNamedStoredProcedureQuery("addRoom").setParameter("room_name",roomData.getRoomName()).setParameter("room_description",roomData.getRoomDescription()).setParameter("room_status",roomData.getRoomStatus()).setParameter("daily_rate",roomData.getDailyRate()).setParameter("room_qty",roomData.getRoomQty()).setParameter("max_guest",roomData.getMaxGuest()).setParameter("room_image",roomData.getRoomImage()).setParameter("room_category",roomData.getRoomCategory()).execute();
        if (!status) {
            msg = "Added";
        }
        else {
            msg = "Error";
        }
        return msg;
    }

    @Override
    public List<Room> getRoomById(Integer id) {
        return roomRepository.findRoomByDeletedFalse(id);
    }

    @Override
    public String deleteRoomById(Integer id) {
        String msg;
        boolean status =  entityManager.createNamedStoredProcedureQuery("deleteRoomById").setParameter("room_id",id).execute();
        if (status) {
            msg = "Error";
        }
        else {
            msg = "Deleted";
        }
        return msg;
    }

    @Override
    public String updateRoom(Integer id, Room roomData) {
        String msg;
        boolean status =  entityManager.createNamedStoredProcedureQuery("updateRoomById").setParameter("id",id).setParameter("room_name",roomData.getRoomName()).setParameter("room_description",roomData.getRoomDescription()).setParameter("room_status",roomData.getRoomStatus()).setParameter("daily_rate",roomData.getDailyRate()).setParameter("room_qty",roomData.getRoomQty()).setParameter("max_guest",roomData.getMaxGuest()).setParameter("room_image",roomData.getRoomImage()).setParameter("room_category",roomData.getRoomCategory()).execute();
        if (!status) {
            msg = "Updated";
        }
        else {
            msg = "Error";
        }
        return msg;
    }
}
