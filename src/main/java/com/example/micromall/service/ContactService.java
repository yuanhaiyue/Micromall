package com.example.micromall.service;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.micromall.entity.Contact;
import com.example.micromall.entity.User;
import com.example.micromall.repository.ContactRepository;
import com.example.micromall.repository.UserRepository;
import com.example.micromall.utils.CreateContact;
import com.example.micromall.utils.JSONResult;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
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

    public JSONResult createContact(Contact contact, HttpSession session){
        User user=userRepository.findById(1).get();
        contact.setUser(user);
        int cnt=contactRepository.insert(contact);
        if (cnt!=0){
           return JSONResult.ok(contact.getId(), "添加成功");
        }
        return JSONResult.errorMsg("添加失败");

    }

    public JSONResult updateContact(Contact contact,HttpSession session){
        int cnt=contactRepository.updateById(contact);
        if (cnt!=0){
            return JSONResult.ok(contact.getId(), "更新成功");
        }
        return JSONResult.errorMsg("更新失败");

    }

    public Contact editContact(Integer id){
        return contactRepository.selectById(id);
    }


    public JSONResult delete(Integer id){
        int cnt=contactRepository.deleteById(id);
        if (cnt!=0){
            return JSONResult.ok("","删除成功");
        }
        return JSONResult.errorMsg("删除失败");
    }

    public Contact getDev(Integer id){
        QueryWrapper<Contact> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("user_id",id ).last("limit 1");
        return contactRepository.selectOne(queryWrapper);
    }


}
