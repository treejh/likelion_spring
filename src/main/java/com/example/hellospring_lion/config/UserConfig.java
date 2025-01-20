package com.example.hellospring_lion.config;

import com.example.hellospring_lion.controller.UserController;
import com.example.hellospring_lion.repository.UserDao;
import com.example.hellospring_lion.repository.UserDaoImpl;
import com.example.hellospring_lion.service.UserService;
import com.example.hellospring_lion.service.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;


@ComponentScan(basePackages = "com.example.hellospring_lion")
public class UserConfig {


//
//    @Bean
//    public UserDao userDao(){
//        return new UserDaoImpl();
//    }
//
//    @Bean
//    public UserService userService(UserDao userDao){
//        //return new UserServiceImpl(userDao);
//        UserServiceImpl userService = new UserServiceImpl();
//        userService.setUserDao(userDao);
//        return userService;
//
//    }
//
//    @Bean
//    public UserController userController(UserService userService){
////        return new UserController(userService);
//        UserController userController = new UserController();
//        userController.setUserService(userService);
//        return userController;
//    }


}