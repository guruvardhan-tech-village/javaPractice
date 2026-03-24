package com.bus.busbooking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bus.busbooking.model.User;
import com.bus.busbooking.repository.UserRepository;
import com.bus.busbooking.exception.UserNotFoundException;
import com.bus.busbooking.dto.UserDTO;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Save user
    public String saveUser(UserDTO dto) {
        User user = new User();
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setAge(dto.getAge());

        userRepository.save(user);
        return "User saved in DB";
    }

    // Get all users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    // public User getUserById(String id) {
    //     return userRepository.findById(id).orElse(null);
    // }
    public User getUserById(String id){
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User with id " + id + " not found"));
    }

    public String deleteUser(String id){
        userRepository.deleteById(id);
        return "User deleted Successfully";
    }

    public String updateUser(String id, User user) {
        User existingUser = userRepository.findById(id).orElse(null);
        if (existingUser != null) {
            existingUser.setName(user.getName());
            existingUser.setEmail(user.getEmail());
            existingUser.setAge(user.getAge());
            userRepository.save(existingUser);
            return "User updated successfully";
        } else {
            return "User not found";
        }
    }
}