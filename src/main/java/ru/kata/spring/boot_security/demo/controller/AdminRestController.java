package ru.kata.spring.boot_security.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.interfaces.RoleService;
import ru.kata.spring.boot_security.demo.service.interfaces.UserService;

import java.util.Collections;
import java.util.List;
import java.util.Set;

@RestController()
@RequestMapping("/admin")
public class AdminRestController {

    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public AdminRestController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping()
    public List<User> index() {
        return userService.getListOfUsers();
    }

    @PostMapping(value = "/new")
    public ResponseEntity<HttpStatus> create(@RequestBody User user) {
        //user.setRoles(Set.copyOf(Collections.singletonList(roleService.getRoleById(1L))));
        userService.addNewUser(user);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
