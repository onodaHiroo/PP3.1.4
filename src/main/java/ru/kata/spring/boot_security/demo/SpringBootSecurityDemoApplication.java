package ru.kata.spring.boot_security.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.Validator;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.UserServiceImpl;
import ru.kata.spring.boot_security.demo.service.interfaces.RoleService;
import ru.kata.spring.boot_security.demo.service.interfaces.UserService;
import ru.kata.spring.boot_security.demo.util.MyValidator;
import ru.kata.spring.boot_security.demo.util.UserValidator;

import java.util.Collections;

@SpringBootApplication
public class SpringBootSecurityDemoApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(SpringBootSecurityDemoApplication.class, args);
		initApplicationDefault(context);
	}

	public static void initApplicationDefault(ConfigurableApplicationContext context){
		UserService userService = context.getBean(UserServiceImpl.class);
		RoleService roleService = context.getBean(RoleService.class);
		MyValidator myValidator = context.getBean(UserValidator.class);

		User admin = new User("admin", "admin@gmail.com", "admin");
		User user = new User("1", "1", "1");

		if(!myValidator.userInDataBase(admin)){
			admin.setRoles(roleService.getAllRoles());
			userService.addNewUser(admin);
		}
		if(!myValidator.userInDataBase(user)){
			user.setRoles(Collections.singletonList(roleService.getRoleById(1L)));
			userService.addNewUser(user);
		}
	}

}
