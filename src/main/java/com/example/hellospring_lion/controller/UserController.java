package com.example.hellospring_lion.controller;

import com.example.hellospring_lion.domain.User;
import com.example.hellospring_lion.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


@Controller
public class UserController {
    @Autowired
    private UserService userService;

    public UserController() {
        System.out.println("UserController () 실행");
    }



    public UserController(UserService userService) {
        this.userService = userService;
    }


    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void joinUser(){
        //실제로 동작할때는 user정보를 사용자로부터 정보를 받겠죠???
        User user = new User();
        user.setName("kang");
        user.setEmail("carami@gmail.com");
        user.setPassword("1111");

        userService.joinUser(user);
    }
}