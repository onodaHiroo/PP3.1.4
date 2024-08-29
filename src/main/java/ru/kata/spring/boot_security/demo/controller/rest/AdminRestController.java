package ru.kata.spring.boot_security.demo.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.interfaces.RoleService;
import ru.kata.spring.boot_security.demo.service.interfaces.UserService;

import java.util.*;

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
    public ResponseEntity<List<User>> index() {
        return new ResponseEntity<>(userService.getListOfUsers(), HttpStatus.OK);
    }

    @PostMapping(value = "/new")
    public ResponseEntity<HttpStatus> create(@RequestBody User user) {
        userService.addOrUpdateNewUser(user);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping(value = "/delete")
    public ResponseEntity<HttpStatus> delete(@RequestParam(value = "id") long id) {
        userService.removeUserById(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PostMapping(value = "/update")
    public ResponseEntity<HttpStatus> edit(@RequestBody User user) {
        userService.addOrUpdateNewUser(user);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/show")
    public ResponseEntity<User> getUserById(@RequestParam(value = "id") long id) {
        return new ResponseEntity<>(userService.show(id), HttpStatus.OK);
    }
}
