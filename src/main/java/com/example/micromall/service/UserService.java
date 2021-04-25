package com.example.micromall.service;




import com.example.micromall.Vo.UserVo;
import com.example.micromall.controller.UserController;
import com.example.micromall.entity.User;
import com.example.micromall.repository.UserRepository;


import com.example.micromall.utils.JSONResult;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
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

    public User createUser(User user,HttpSession session){
        if (StringUtils.isEmpty(user.getName())){

            throw new RuntimeException("用户名为空");
        }
        if (StringUtils.isEmpty(user.getPassword())){
            throw new RuntimeException("密码不能为空");
        }

        User userOne= userRepository.save(user);
        UserVo userVo=new UserVo(userOne.getId(),userOne.getName());
        session.setAttribute("user", userVo);
        return userOne;
    }


    public JSONResult loginUser(String name, String password, HttpSession session){
        User user=userRepository.findByNameAndPassword(name, password);
        if (user==null){
           return JSONResult.errorMsg("账号或密码错误");
        }
        UserVo userVo=new UserVo(user.getId(),user.getName());
        session.setAttribute("user", userVo);
        return JSONResult.ok(new UserController.LoginVo(user,session.getId()),"登录成功");
    }

    public Map<String,Object> delete(User user){
        userRepository.delete(user);
        Map<String,Object> map=new HashMap<>();
        map.put("msg", "账号已注销");
        map.put("state", 1);
        return map;
    }
    public void logout(HttpSession session){
        session.removeAttribute("user");
        session.invalidate();
    }

    public List<User> select(){
        return userRepository.findAll();
    }

    public UserVo user(HttpSession session){
        return (UserVo) session.getAttribute("user");
    }


}
