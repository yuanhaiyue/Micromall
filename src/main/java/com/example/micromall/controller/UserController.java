package com.example.micromall.controller;

import com.example.micromall.entity.User;
import com.example.micromall.service.UserService;
import com.example.micromall.utils.Create;
import com.example.micromall.utils.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author 14760
 */

@Validated
@RequestMapping("/users")
@RestController
public class UserController {

    final UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public User loginUser(String name,String password){
        return userService.loginUser(name, password);
    }

    @PostMapping("/register")
    public User registerUser(@RequestBody @Validated(value = Create.class) User user){
        return userService.createUser(user);
    }
    @PostMapping("/cancellation")
    public Map<String,Object> cancellationUser(@RequestBody @Validated(value = Update.class) User user){
        return userService.delete(user);
    }
    @GetMapping("/select")
    public List<User> selectUser(){
        return userService.select();
    }
}
