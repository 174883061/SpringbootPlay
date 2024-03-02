package com.practice.practicespringbootjpa.controller;

import com.practice.practicespringbootjpa.model.User;
import com.practice.practicespringbootjpa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JpaPracticeController {

    @Autowired //完成自动导入
    private UserService userService;
//    @Autowired
//    UserRepository userRepository;
    @GetMapping("/findallusers")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
//        return userRepository.findAll();
    }

    @PostMapping("/adduser")
    public void addUser(@RequestBody User user){
        userService.addUser(user);
    }

    @DeleteMapping("/deleteUser/{id}")
    public String deleteUserById(@PathVariable Long id) {
        userService.deleteById(id);
        return "User with ID " + id + " deleted successfully.";
    }

    @PutMapping("/users/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User userDetails) {
        return userService.updateUser(id, userDetails);
    }
}
