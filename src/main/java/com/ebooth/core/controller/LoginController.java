package com.ebooth.core.controller;

import com.ebooth.core.model.User;
import com.ebooth.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @Autowired
    private UserService userService;

    @GetMapping(path = "/login")
    public User login() {
        return userService.getCurrentUser();
    }
}
