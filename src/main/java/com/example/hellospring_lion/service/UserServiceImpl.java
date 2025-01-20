package com.example.hellospring_lion.service;

import com.example.hellospring_lion.domain.User;
import com.example.hellospring_lion.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService{
    private UserDao userDao;

//    public UserServiceImpl(@Qualifier("userDao") UserDao userDao) {
//        this.userDao = userDao;
//    }

    @Autowired
    public void setUserDao(@Qualifier("userDao") UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void joinUser(User user) {
        userDao.addUser(user);
    }

    public void getUser(String id) {
        User user = userDao.getUserOptional().orElse(new User());
    }


}