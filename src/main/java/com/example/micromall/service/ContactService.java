package com.example.micromall.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.example.micromall.controller.ContactController;


import com.example.micromall.entity.Contact;
import com.example.micromall.entity.User;
import com.example.micromall.repository.ContactRepository;
import com.example.micromall.repository.UserRepository;
import com.example.micromall.utils.CreateContact;
import com.example.micromall.utils.Results;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 14760
 */
@Service
public class ContactService {
    final ContactRepository contactRepository;
    final UserRepository userRepository;

    public ContactService(ContactRepository contactRepository, UserRepository userRepository) {
        this.contactRepository = contactRepository;
        this.userRepository = userRepository;
    }

    public List<Contact> selectAll(Integer id){
        Map<String,Object> map=new HashMap<>(1);
        map.put("user_id", id);
        return contactRepository.selectByMap(map);

    }

    public Results createContact(CreateContact createContact){
        User user=userRepository.findById(createContact.getUserId()).get();
        Contact contact= createContact.getContact(user);
        int cnt=contactRepository.insert(contact);
        if (cnt!=0){
            return new Results("添加地址成功", 200);
        }
        return new Results("添加失败", 400);
    }

    public Results updateContact(Contact contact){
        int cnt=contactRepository.updateById(contact);
        if (cnt!=0){
            return new Results("修改地址成功", 200);
        }
        return new Results("修改失败", 400);
    }




}
