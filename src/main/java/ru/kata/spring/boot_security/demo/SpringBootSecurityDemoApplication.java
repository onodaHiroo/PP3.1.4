package ru.kata.spring.boot_security.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.UserServiceImpl;
import ru.kata.spring.boot_security.demo.service.interfaces.RoleService;
import ru.kata.spring.boot_security.demo.service.interfaces.UserService;
import ru.kata.spring.boot_security.demo.util.Init;

import java.util.Collections;
import java.util.Set;

@SpringBootApplication
public class SpringBootSecurityDemoApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringBootSecurityDemoApplication.class, args);
        Init init = new Init(context);
    }
}
