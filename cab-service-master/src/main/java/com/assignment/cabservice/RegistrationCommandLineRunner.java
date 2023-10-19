package com.assignment.cabservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import com.assignment.cabservice.service.CustomUserDetailsService;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;

@Component
public class RegistrationCommandLineRunner implements CommandLineRunner {

    private final CustomUserDetailsService userDetailsService;
    private final PasswordEncoder encoder;

    @Autowired
    public RegistrationCommandLineRunner(CustomUserDetailsService userDetailsService, PasswordEncoder encoder) {
        this.userDetailsService = userDetailsService;
        this.encoder = encoder;
    }

    @Override
    public void run(String... args) throws Exception {
        // Create an ADMIN user
        String adminUsername = "admin";
        String adminRoles = "ADMIN";
        String adminPassword = "adminPassword";

        String encodedAdminPassword = encoder.encode(adminPassword);
        userDetailsService.registerUser(adminUsername, adminRoles, encodedAdminPassword);

        // Create a USER user
        String userUsername = "myuser";
        String userRoles = "USER";
        String userPassword = "mypassword";

        String encodedUserPassword = encoder.encode(userPassword);
        userDetailsService.registerUser(userUsername, userRoles, encodedUserPassword);

        // Create a user with both ADMIN and USER roles
        String adminUserUsername = "myadmin";
        String adminUserRoles = "ADMIN,USER"; // Assign both roles
        String adminUserPassword = "myadmin";

        String encodedAdminUserPassword = encoder.encode(adminUserPassword);
        userDetailsService.registerUser(adminUserUsername, adminUserRoles, encodedAdminUserPassword);
    }
}