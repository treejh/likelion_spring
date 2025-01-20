package com.example.hellospring_lion.repository;

import com.example.hellospring_lion.domain.User;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository("userDao")
public class UserDaoImpl implements UserDao{

    @Override
    public User getUser(String email) {
        return null;
    }

    @Override
    public List<User> getUsers() {
        return null;
    }

    @Override
    public void addUser(User user) {
        System.out.println(user+"의 정보가 잘 저장되었습니다.");
    }

    @Override
    public Optional<User> getUserOptional() {

        User user = new User();
        return Optional.of(user);
    }
}