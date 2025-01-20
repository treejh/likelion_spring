package com.example.hellospring_lion.repository;

import com.example.hellospring_lion.domain.User;
import java.util.List;
import java.util.Optional;

public interface UserDao {
    public User getUser(String email);
    public List<User> getUsers();
    public void addUser(User user);

    public Optional<User> getUserOptional();
}