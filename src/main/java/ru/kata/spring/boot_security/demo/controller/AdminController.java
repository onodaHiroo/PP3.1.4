package ru.kata.spring.boot_security.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.interfaces.RoleService;
import ru.kata.spring.boot_security.demo.service.interfaces.UserService;

import java.util.Collection;
import java.util.Collections;

@Controller()
@RequestMapping("/admin")
public class AdminController {

    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public AdminController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping()
    public String index(ModelMap model) {
        model.addAttribute("users", userService.getListOfUsers());
        return "admin/index";
    }

    @GetMapping(value = "/addNewUserButton")
    public String addNewUser() {
        return "redirect:/admin/new";
    }

    @GetMapping(value = "/new")
    public String newPerson(@ModelAttribute("user") User user) {
        return "admin/new";
    }

    @PostMapping(value = "/new")
    public String create(@ModelAttribute("user") User user, @RequestParam(value = "role") String role) {

        //убрать бы это в сервис
        if (role.equals("admin")) {
            user.setRoles(roleService.getAllRoles());
        } else {
            user.setRoles(Collections.singletonList(roleService.getRoleById(1L)));
        }

        userService.addNewUser(user);
        return "redirect:/admin";
    }

    @GetMapping(value = "/edit")
    public String updatePerson(@RequestParam(value = "id") long id, ModelMap modelMap) {
        modelMap.addAttribute("user", userService.show(id));
        System.out.println(modelMap);
        return "admin/edit";
    }

    @PostMapping(value = "/update")
    public String edit(@ModelAttribute("user") User user, @RequestParam(value = "role") String role) {

        //убрать бы это в сервис
        if (role.equals("admin")) {
            user.setRoles(roleService.getAllRoles());
        } else {
            user.setRoles(Collections.singletonList(roleService.getRoleById(1L)));
        }

        userService.updateUser(user);
        return "redirect:/admin";
    }

    @GetMapping(value = "/delete")
    public String delete(@RequestParam(value = "id") long id) {
        userService.removeUserById(id);
        return "redirect:/admin";
    }

}
