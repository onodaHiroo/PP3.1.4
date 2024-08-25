package ru.kata.spring.boot_security.demo.controller;

import org.springframework.security.core.Authentication;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.kata.spring.boot_security.demo.model.User;

@RestController
@RequestMapping("/user")
public class UserRestController {

    @GetMapping("")
    public User currentUser(Authentication authentication) {
        User user = (User) authentication.getPrincipal();
        //modelMap.addAttribute("user", user);
        return user;
    }
}
