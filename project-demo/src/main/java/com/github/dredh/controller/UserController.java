package com.github.dredh.controller;

import com.dredh.service.PersonService;
import com.github.dredh.entity.User;
import com.github.dredh.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    PersonService personService;

    @PostMapping
    public User insert(@RequestBody User user) {
        return userRepository.save(user);
    }

    @GetMapping
    public List<User> get() {
        return userRepository.findAll();
    }
}
