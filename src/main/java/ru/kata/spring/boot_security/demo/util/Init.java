package ru.kata.spring.boot_security.demo.util;
import org.springframework.context.ConfigurableApplicationContext;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.UserServiceImpl;
import ru.kata.spring.boot_security.demo.service.interfaces.RoleService;
import ru.kata.spring.boot_security.demo.service.interfaces.UserService;

import java.util.Collections;
import java.util.Set;

public class Init {

    public Init (ConfigurableApplicationContext context){
        UserService userService = context.getBean(UserServiceImpl.class);
        RoleService roleService = context.getBean(RoleService.class);

        roleService.addNewRole(new Role(1L, "ROLE_USER"));
        roleService.addNewRole(new Role(2L, "ROLE_ADMIN"));

        User admin = new User("admin", "admin", "admin");
        User user = new User("user", "user", "user");

        admin.setRoles(roleService.getAllRoles());
        userService.addNewUser(admin);

        user.setRoles(Set.copyOf(Collections.singletonList(roleService.getRoleById(1L))));
        userService.addNewUser(user);
    }


}
