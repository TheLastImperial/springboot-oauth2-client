package com.thelastimperial.oauth2_client.controllers;

import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@RestController
public class HomePageController {
    @GetMapping("/")
    public String withoutSecurity() {
        return "Page without security";
    }
    @GetMapping("/security")
    public String withSecurity() {
        return "Page with security";
    }
    
    @GetMapping("/user")
    public String userRole() {
        return "User logged";
    }

    @GetMapping("/admin")
    public String adminUser() {
        return "Admin user";
    }
}
