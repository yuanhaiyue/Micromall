package com.example.micromall.utils;

import com.example.micromall.entity.Contact;
import com.example.micromall.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

/**
 * @author 14760
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public  class CreateContact{
    @NotBlank(message = "不能为空")
    private String address;
    @NotBlank(message = "不能为空")
    private String name;
    @NotBlank(message = "不能为空")
    private String phoneNumber;
    @NotBlank(message = "不能为空")
    private Integer userId;

    public  Contact getContact(User user){
        Contact contact=new Contact();
        contact.setUser(user);
        contact.setName(name);
        contact.setAddress(address);
        contact.setPhoneNumber(phoneNumber);
        return contact;
    }



}