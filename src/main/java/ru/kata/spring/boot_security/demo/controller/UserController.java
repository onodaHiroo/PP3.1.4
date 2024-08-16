package ru.kata.spring.boot_security.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.interfaces.UserService;

import java.security.Principal;


@Controller
@RequestMapping("user")
public class UserController {

    @GetMapping("")
    public String currentUserName(Authentication authentication, ModelMap modelMap) {
        User user = (User) authentication.getPrincipal();
        modelMap.addAttribute("user", user);
        return "user/user";
    }
}
