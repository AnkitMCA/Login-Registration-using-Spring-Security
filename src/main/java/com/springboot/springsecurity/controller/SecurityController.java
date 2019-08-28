package com.springboot.springsecurity.controller;

import com.springboot.springsecurity.model.User;
import com.springboot.springsecurity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * The type In memory auth controller.
 */
@RestController
@RequestMapping("/")
public class SecurityController {

    /**
     * The Password encoder.
     */
    @Autowired
    PasswordEncoder passwordEncoder;

    /**
     * The User repository.
     */
    @Autowired
    UserRepository userRepository;

    /**
     * Index string.
     *
     * @return the string
     */
    @GetMapping("")
    public String index() {
        return "Successfully logged-in.";
    }

    /**
     * Login model and view.
     *
     * @return the model and view
     */
    @GetMapping("login")
    public ModelAndView login() {
        ModelAndView modelAndView = new ModelAndView("login", "user", new User());
        return modelAndView;
    }

    /**
     * Register model and view.
     *
     * @return the model and view
     */
    @GetMapping("register")
    public ModelAndView register() {
        User user = new User();
        ModelAndView modelAndView = new ModelAndView("register", "user", user);
        return modelAndView;
    }

    /**
     * Register user string.
     *
     * @param user the user
     * @return the string
     */
    @PostMapping("registerUser")
    public String registerUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return "Registration Success, Please logged-in.";
    }

    /**
     * Other page string.
     *
     * @return the string
     */
    @GetMapping("/other")
    public String otherPage() {
        return "Another Page.";
    }

}
