package com.example.micromall.controller;


import com.example.micromall.entity.Contact;
import com.example.micromall.entity.User;
import com.example.micromall.service.ContactService;
import com.example.micromall.utils.CreateContact;
import com.example.micromall.utils.JSONResult;
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
import javax.servlet.http.HttpSession;
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
    public JSONResult selectAll(Integer userId){
        return JSONResult.ok(contactService.selectAll(userId));
    }


    @PostMapping("/save")
    public JSONResult saveContact(@RequestBody Contact contact, HttpSession session){
        if (contact.getId()!=null){
            return contactService.updateContact(contact,session);
        }
        return contactService.createContact(contact,session);
    }

    @GetMapping("/edit")
    public JSONResult editContact(Integer id){
        return JSONResult.ok(contactService.editContact(id));
    }


    @PostMapping("/delete")
    public JSONResult deleteContact(Integer id){

        return contactService.delete(id);
    }

    @GetMapping("/def")
    public JSONResult devContact(){
        return JSONResult.ok(contactService.getDev(1));
    }


}

