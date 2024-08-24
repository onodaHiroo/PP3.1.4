package ru.kata.spring.boot_security.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import ru.kata.spring.boot_security.demo.util.Init;

@SpringBootApplication
public class SpringBootSecurityDemoApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringBootSecurityDemoApplication.class, args);
        new Init(context);
    }
}
