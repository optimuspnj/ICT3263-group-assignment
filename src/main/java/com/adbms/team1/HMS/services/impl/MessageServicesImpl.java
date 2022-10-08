package com.adbms.team1.HMS.services.impl;

import com.adbms.team1.HMS.Model.Message;
import com.adbms.team1.HMS.repositories.MessageRepository;
import com.adbms.team1.HMS.services.MessageServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class MessageServicesImpl implements MessageServices {
    @Autowired
    MessageRepository messageRepository;

    @Autowired
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Message> getAllMessages() {
        return messageRepository.getAllMessages();
    }

    @Override
    public String addMessage(Message messageData) {
        String msg;
        boolean status =  entityManager.createNamedStoredProcedureQuery("addMessage").setParameter("name",messageData.getName()).setParameter("email",messageData.getEmail()).setParameter("phone",messageData.getPhone()).setParameter("title",messageData.getTitle()).setParameter("message",messageData.getMessage()).execute();
        if (!status) {
            msg = "Added";
        }
        else {
            msg = "Error";
        }
        return msg;
    }

    @Override
    public String deleteMessageById(Integer id) {
        String msg;
        boolean status =  entityManager.createNamedStoredProcedureQuery("deleteMessageById").setParameter("id",id).execute();
        if (status) {
            msg = "Error";
        }
        else {
            msg = "Deleted";
        }
        return msg;
    }
}
