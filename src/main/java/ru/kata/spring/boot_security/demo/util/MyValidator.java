package ru.kata.spring.boot_security.demo.util;

import ru.kata.spring.boot_security.demo.model.User;

public interface MyValidator {
    boolean userInDataBase(User user);
}
