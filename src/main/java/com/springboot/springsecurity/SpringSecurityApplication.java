package com.springboot.springsecurity;

import com.springboot.springsecurity.model.Role;
import com.springboot.springsecurity.model.User;
import com.springboot.springsecurity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Arrays;

@SpringBootApplication
public class SpringSecurityApplication implements CommandLineRunner {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;


    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        User user = new User();
        user.setId(1L);
        user.setName("Ankit");
        user.setUsername("ankit@tothenew.com");
        user.setPassword(passwordEncoder.encode("akak"));
        user.setRoles(Arrays.asList(new Role("USER")));
        userRepository.save(user);


        User user1 = new User();
        user1.setId(2L);
        user1.setName("Sumit");
        user1.setUsername("sumit@tothenew.com");
        user1.setPassword(passwordEncoder.encode("sksk"));
        user1.setRoles(Arrays.asList(new Role("ADMIN")));
        userRepository.save(user1);
    }
}
