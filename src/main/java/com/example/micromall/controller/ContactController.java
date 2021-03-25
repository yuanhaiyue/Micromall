package com.example.micromall.controller;


import com.example.micromall.entity.Contact;
import com.example.micromall.entity.User;
import com.example.micromall.service.ContactService;
import com.example.micromall.utils.CreateContact;
import com.example.micromall.utils.Results;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.List;

/**
 * @author 14760
 */
@RequestMapping("/contact")
@RestController
@Validated
public class ContactController {
    final ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping("/list")
    public List<Contact> selectAll(Integer userId){
        return contactService.selectAll(userId);
    }


    @PostMapping("/create")
    public Results createContact(@RequestBody CreateContact contact){
        return contactService.createContact(contact);
    }

    @PostMapping("/update")
    public Results updateContact(Contact contact){
        return contactService.updateContact(contact);
    }
}

