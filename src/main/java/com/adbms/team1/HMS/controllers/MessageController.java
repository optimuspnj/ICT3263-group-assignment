package com.adbms.team1.HMS.controllers;

import com.adbms.team1.HMS.Model.Booking;
import com.adbms.team1.HMS.Model.Message;
import com.adbms.team1.HMS.services.MessageServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/messages")
public class MessageController {
    @Autowired
    MessageServices messageServices;

    @GetMapping("/all")
    public List<Message> getAllMessages () {
        return messageServices.getAllMessages();
    }

    @PostMapping("/add")
    public String addMessage(@RequestBody Message messageData) {
        return messageServices.addMessage(messageData);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteMessageById(@PathVariable Integer id) {
        return messageServices.deleteMessageById(id);
    }
}
