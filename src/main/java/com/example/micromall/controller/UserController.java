package com.example.micromall.controller;

import com.example.micromall.Vo.UserVo;
import com.example.micromall.entity.User;
import com.example.micromall.service.UserService;
import com.example.micromall.utils.Create;
import com.example.micromall.utils.JSONResult;
import com.example.micromall.utils.LogoutResult;
import com.example.micromall.utils.Update;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * @author 14760
 */

@Validated
@RequestMapping("/user")
@RestController
public class UserController {

    final UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/user")
    public JSONResult loginMsg(HttpSession session){
        return JSONResult.ok(new LoginVo(userService.user(session),session.getId()),"");
    }


    @PostMapping("/login")
    public JSONResult loginUser(@RequestBody LoginUser loginUser, HttpSession session){
        return userService.loginUser(loginUser.getUsername(), loginUser.getPassword(),session);
    }

    @GetMapping("/logout")
    public LogoutResult logoutUser(HttpServletRequest request){
        userService.logout(request.getSession());
        return LogoutResult.logout("退出登录成功");
    }


    @PostMapping("/register")
    public JSONResult registerUser(@RequestBody @Validated(value = Create.class) User user,HttpSession session){
        return JSONResult.ok(LoginVo.information(  userService.createUser(user,session),session.getId()),"注册成功");
    }
    @PostMapping("/cancellation")
    public Map<String,Object> cancellationUser(@RequestBody @Validated(value = Update.class) User user){
        return userService.delete(user);
    }
    @GetMapping("/select")
    public List<User> selectUser(){
        return userService.select();
    }


    @Data
    public static class LoginVo{
        private String sessionId;
        private Integer id;
        private String username;
        public static LoginVo information(User user,String sessionId){
            return new LoginVo(user, sessionId);
        }

        public LoginVo(User user,String sessionId){
            this.id=user.getId();
            this.username=user.getName();
            this.sessionId=sessionId;
        }
        public LoginVo(UserVo user, String sessionId){
            this.id=user.getId();
            this.username=user.getName();
            this.sessionId=sessionId;
        }
    }
    @Data
    private static class LoginUser{
        private String username;
        private String password;
    }
}
