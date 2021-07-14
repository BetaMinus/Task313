package com.task313;

import com.task313.model.Role;
import com.task313.model.User;
import com.task313.service.RoleService;
import com.task313.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Arrays;
import java.util.Collections;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Bean
    CommandLineRunner run(UserService userService, RoleService roleService, PasswordEncoder passwordEncoder) {
        return args -> {
            Role roleAdmin = new Role("ROLE_Admin");
            Role roleUser = new Role("ROLE_User");

            User admin1 = new User("admin", "admin", 111, "admin@mail", passwordEncoder.encode("admin"), Arrays.asList(roleAdmin, roleUser));
            User admin2 = new User("admin2", "admin2", 222, "admin2@mail", passwordEncoder.encode("admin"), Collections.singletonList(roleAdmin));
            User user1 = new User("user1", "user1", 11, "user1@mail", passwordEncoder.encode("admin"), Collections.singletonList(roleUser));
            User user2 = new User("user2", "user2", 22, "user2@mail", passwordEncoder.encode("user2"), Collections.singletonList(roleUser));
            User user3 = new User("user3", "user3", 33, "user3@mail", passwordEncoder.encode("user3"), Collections.singletonList(roleUser));

//            roleService.create(roleAdmin);
//            roleService.create(roleUser);
//
//            userService.create(admin1);
//            userService.create(admin2);
//            userService.create(user1);
//            userService.create(user2);
//            userService.create(user3);
        };
    }
}