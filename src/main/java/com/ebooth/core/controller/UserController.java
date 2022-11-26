package com.ebooth.core.controller;

import com.ebooth.core.model.User;
import com.ebooth.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping(path = "/user/")
    public ResponseEntity<List<User>> findAll() {
        return ResponseEntity.ok(userService.findAll());
    }

    @GetMapping(path = "/user/{username}")
    public Optional<User> findById(@PathVariable("username") String username) {
        return userService.findByUsername(username);
    }

    @PostMapping(path = "user")
    public User post(@RequestBody User user) {
        return userService.saveUser(user);
    }
}
