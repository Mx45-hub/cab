package com.assignment.cabservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.assignment.cabservice.repository.UserRepository;
import com.assignment.cabservice.service.CustomUserDetailsService;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Autowired
    UserRepository users;

    @Autowired
    private PasswordEncoder encoder;


    @GetMapping("/registration")
    public String reg(){
        return "register";
    }

    @PostMapping("/registration")
    public String addUser(@RequestParam("username") String username,
                         @RequestParam("roles") String roles,
                         @RequestParam("password") String password,
                         HttpSession session) {
        String encodedPassword = encoder.encode(password);
        userDetailsService.registerUser(username, roles, encodedPassword);
        return "register";
    }



}
