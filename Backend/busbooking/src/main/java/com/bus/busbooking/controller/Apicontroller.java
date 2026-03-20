package com.bus.busbooking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.bus.busbooking.model.User;
import com.bus.busbooking.repository.UserRepository;

@RestController
public class Apicontroller {
    
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/addUser")
    public String addUser(@RequestBody User user) {
        userRepository.save(user);
        return "User saved in DB";
    }

    @GetMapping("/getAllUsers")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

}
