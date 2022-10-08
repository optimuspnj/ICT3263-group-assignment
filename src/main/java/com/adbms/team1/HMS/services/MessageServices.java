package com.adbms.team1.HMS.services;

import com.adbms.team1.HMS.Model.Message;

import java.util.List;

public interface MessageServices {
    List<Message> getAllMessages();

    String addMessage(Message messageData);

    String deleteMessageById(Integer id);
}
