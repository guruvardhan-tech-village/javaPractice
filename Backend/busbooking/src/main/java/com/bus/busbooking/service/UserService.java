package com.bus.busbooking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bus.busbooking.model.User;
import com.bus.busbooking.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Save user
    public String saveUser(User user) {
        userRepository.save(user);
        return "User saved in DB";
    }

    // Get all users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}