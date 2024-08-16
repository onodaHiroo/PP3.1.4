package ru.kata.spring.boot_security.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.Validator;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.UserServiceImpl;
import ru.kata.spring.boot_security.demo.service.interfaces.RoleService;
import ru.kata.spring.boot_security.demo.service.interfaces.UserService;

import javax.persistence.NoResultException;
import java.util.Collections;
import java.util.Set;

@SpringBootApplication
public class SpringBootSecurityDemoApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(SpringBootSecurityDemoApplication.class, args);
		initApplicationDefault(context);
	}

	public static void initApplicationDefault(ConfigurableApplicationContext context){
		UserService userService = context.getBean(UserServiceImpl.class);
		RoleService roleService = context.getBean(RoleService.class);

		User admin = new User("admin", "admin@gmail.com", "admin");
		User user = new User("1", "1", "1");

		admin.setRoles(roleService.getAllRoles());
		userService.addNewUser(admin);

		user.setRoles(Set.copyOf(Collections.singletonList(roleService.getRoleById(1L))));
		userService.addNewUser(user);
	}
}
