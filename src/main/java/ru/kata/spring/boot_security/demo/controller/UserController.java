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
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public String currentUserName(Authentication authentication, ModelMap modelMap) {
        User user = (User) authentication.getPrincipal();
        modelMap.addAttribute("user", user);
        return "user/user";
    }




//
//    @GetMapping(value = "/addNewUserButton")
//    public String addNewUser() {
//        return "redirect:/new";
//    }
//
//    @GetMapping(value = "/new")
//    public String newPerson(@ModelAttribute("user") User user) {
//        return "new";
//    }
//
//    @PostMapping(value = "/new")
//    public String create(@ModelAttribute("user") User user) {
//        userService.addNewUser(user);
//        return "redirect:/";
//    }
//
//    @GetMapping(value = "/edit")
//    public String updatePerson(@RequestParam(value = "id") long id, ModelMap modelMap) {
//        modelMap.addAttribute("user", userService.show(id));
//        System.out.println(modelMap);
//        return "edit";
//    }
//
//    @PostMapping(value = "/update")
//    public String edit(@ModelAttribute("user") User user) {
//        userService.updateUser(user);
//        return "redirect:/";
//    }
//
//    @GetMapping(value = "/delete")
//    public String delete(@RequestParam(value = "id") long id) {
//        userService.removeUserById(id);
//        return "redirect:/";
//    }
}
