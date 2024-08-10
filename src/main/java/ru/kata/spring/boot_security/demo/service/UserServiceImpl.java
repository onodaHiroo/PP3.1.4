package ru.kata.spring.boot_security.demo.service;

import org.example.springboot.dao.UserDao;
import org.example.springboot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void addNewUser(User user) {
        userDao.addNewUser(user);
    }

    @Override
    public List<User> getListOfUsers() {
        return userDao.getListOfUsers();
    }

    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    @Override
    public void removeUserById(long id) {
        userDao.removeUserById(id);
    }

    @Override
    public User show(long id) {
        return userDao.show(id);
    }
}
