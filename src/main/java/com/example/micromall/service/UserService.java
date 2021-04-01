package com.example.micromall.service;




import com.example.micromall.entity.User;
import com.example.micromall.repository.UserRepository;


import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author 14760
 */
@Service
public class UserService {

    final UserRepository userRepository;


    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User user){
        if (StringUtils.isEmpty(user.getName())){

            throw new RuntimeException("用户名为空");
        }
        if (StringUtils.isEmpty(user.getPassword())){
            throw new RuntimeException("密码不能为空");
        }
       return userRepository.save(user);
    }


    public User loginUser(String name,String password){
        User user=userRepository.findByNameAndPassword(name, password);
        if (user==null){
            throw new RuntimeException("用户名或密码错误");
        }
        return user;
    }

    public Map<String,Object> delete(User user){
        userRepository.delete(user);
        Map<String,Object> map=new HashMap<>();
        map.put("msg", "账号已注销");
        map.put("state", 200);
        return map;
    }

//    @PostConstruct
//    public void init(){
//        List<User> list=new ArrayList<>();
//        list.add(new User("林森","linsen"));
//        list.add(new User("廖孔杰","lkj"));
//        list.add(new User("蔡浩浩","chh"));
//        list.add(new User("赵sb","zyb"));
//        userRepository.saveAll(list);
//    }

    public List<User> select(){
        return userRepository.findAll();
    }



}
