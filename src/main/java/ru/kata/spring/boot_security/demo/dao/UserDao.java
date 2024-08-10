package ru.kata.spring.boot_security.demo.dao;


import org.example.springboot.model.User;

import java.util.List;

public interface UserDao {
    void addNewUser(User user);

    List<User> getListOfUsers();

    void updateUser(User user);

    void removeUserById(long id);

    User show(long id);
}