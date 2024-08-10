package ru.kata.spring.boot_security.demo.controller;

import org.example.springboot.model.User;
import org.example.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/")
    public String index(ModelMap model) {
        model.addAttribute("users", userService.getListOfUsers());
        return "index";
    }

    @GetMapping(value = "/addNewUserButton")
    public String addNewUser() {
        return "redirect:/new";
    }

    @GetMapping(value = "/new")
    public String newPerson(@ModelAttribute("user") User user) {
        return "new";
    }

    @PostMapping(value = "/new")
    public String create(@ModelAttribute("user") User user) {
        userService.addNewUser(user);
        return "redirect:/";
    }

    @GetMapping(value = "/edit")
    public String updatePerson(@RequestParam(value = "id") long id, ModelMap modelMap) {
        modelMap.addAttribute("user", userService.show(id));
        System.out.println(modelMap);
        return "edit";
    }

    @PostMapping(value = "/update")
    public String edit(@ModelAttribute("user") User user) {
        userService.updateUser(user);
        return "redirect:/";
    }

    @GetMapping(value = "/delete")
    public String delete(@RequestParam(value = "id") long id) {
        userService.removeUserById(id);
        return "redirect:/";
    }
}
