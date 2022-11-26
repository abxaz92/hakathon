package com.ebooth.core.service;

import com.ebooth.core.model.User;
import com.ebooth.core.repository.UserRepository;
import com.ebooth.core.utils.UserPrinc;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public Optional<User> findByUsername(String username) {
        return userRepository.findUserByUsername(username);
    }

    public User getCurrentUser() {
        UserPrinc principal = (UserPrinc) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userRepository.findUserByUsername(principal.getUser().getUsername()).get();
    }

    public User saveUser(User user) {
        Optional<User> byUsername = userRepository.findUserByUsername(user.getUsername());
        if (byUsername.isPresent()) {
            log.warn("User {} exists", user.getUsername());
            throw new RuntimeException();
        }

        user.setReputation("5");
        user.setMarksCount(0);
        userRepository.save(user);
        return user;
    }
}
