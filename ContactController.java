package com.example.portfolio_web.controller;

import com.example.portfolio_web.entity.Contact;
import com.example.portfolio_web.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contact")
@CrossOrigin
public class ContactController {

    @Autowired
    private ContactRepository contactRepository;

    @PostMapping("/save")
    public String saveContact(@RequestBody Contact contact) {
        contactRepository.save(contact);
        return "Message Saved Successfully";
    }
    @GetMapping("/all")
    public List<Contact> getAllMessages()
    {
        return contactRepository.findAll();
    }
}