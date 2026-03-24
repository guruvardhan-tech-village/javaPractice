package com.bus.busbooking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bus.busbooking.model.User;
import com.bus.busbooking.service.UserService;



@RestController         //tells to spring that this class is a controller and it will handle the incoming requests

public class Welcome {

    //private List<User> userList = new ArrayList<>();

    @GetMapping("/welcome")  //(@getmapping is used to handle GET requests) when user hits the /welcome endpoint, this method will be called and it will return the welcome message 
    public String welcome() {
        return "Welcome to the Bus Booking System! 🚍";
    }
    @GetMapping("/user")
    public String getUser() {
        return "User: Guru";
    }
    @GetMapping("/greet")
    public String greetUser(@RequestParam String name) {  //@RequestParam is used to extract the value of the name parameter from the query string of the request URL. For example, if the user sends a GET request to /greet?name=John, the value of name will be "John". The method then returns a greeting message that includes the user's name.
        return "Hello " + name;
    }

    // @PostMapping("/addUser") //@PostMapping is used to handle POST requests. When a user sends a POST request to the /addUser endpoint with a name in the request body, this method will be called. The @RequestBody annotation is used to extract the value of the name parameter from the body of the POST request. For example, if the user sends a POST request to /addUser with a JSON body like {"name": "John"}, the value of name will be "John". The method then returns a message confirming that the user has been added successfully.
    // public String addUser(@RequestBody String name) {  //@RequestBody is used to extract the value of the name parameter from the body of the POST request. For example, if the user sends a POST request to /addUser with a JSON body like {"name": "John"}, the value of name will be "John". The method then returns a message confirming that the user has been added successfully.
    //     return "User " + name + " added successfully";
    // }

    // @PostMapping("/addUser")
    // public String addUser(@RequestBody User user) {
    //     userList.add(user);
    //     return "User added successfully";
    // }

    // @GetMapping("/getAllUsers")
    // public List<User> getAllUsers() {
    //     return userList;
    // }
    
    @Autowired
    private UserService userService;

    @PostMapping("/addUser")
    public String addUser(@RequestBody User user) {
        userService.saveUser(user);
        return "User saved in DB";
    }

    @GetMapping("/getAllUsers")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
    @GetMapping("/getUser/{id}")
    public User getUserById(@PathVariable String id) {
        return userService.getUserById(id);
    }
    
    @DeleteMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable String id){
        return userService.deleteUser(id);
    }
    @PutMapping("/updateUser/{id}")
    public String updateUser(@PathVariable String id, @RequestBody User user) {
        return userService.updateUser(id, user);
    }
}
