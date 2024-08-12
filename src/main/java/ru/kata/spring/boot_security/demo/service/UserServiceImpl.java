package ru.kata.spring.boot_security.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring.boot_security.demo.dao.UserDao;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.security.MyUserDetails;

import javax.persistence.NoResultException;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> getListOfUsers() {
        return userDao.getListOfUsers();
    }

    @Override
    public User show(long id) {
        return userDao.show(id);
    }

    @Transactional
    @Override
    public void addNewUser(User user) {
        userDao.addNewUser(user);
    }

    @Transactional
    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    @Transactional
    @Override
    public void removeUserById(long id) {
        userDao.removeUserById(id);
    }


    /////////////////USERSDETAILSERVICE/////////////////
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException, NoResultException {
//        Optional<User> user = Optional.of(userDao.findByEmail(email));
//        if (user.isEmpty()) {
//            throw new UsernameNotFoundException("User not found!");
//        }
//        return new MyUserDetails(user.get());


        return new MyUserDetails(userDao.findByEmail(email));
    }
}
