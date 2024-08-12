package ru.kata.spring.boot_security.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.kata.spring.boot_security.demo.model.User;

@Controller
@RequestMapping("auth")
public class AuthController {

    @GetMapping("/login")
    public String loginPage() {
        return "auth/login";
    }

    @GetMapping("registration")
    public String registrationPage(@ModelAttribute ("user") User user) {
        return "auth/registration";
    }
    @PostMapping("/auth/registration")
    public String performRegistration(@ModelAttribute ("user") User user) {
        return "auth/registration";
    }
}
