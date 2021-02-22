package com.stacksimplify.restservices.controllers;

import com.stacksimplify.restservices.entities.User;
import com.stacksimplify.restservices.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//Controller
@RestController
public class UserController {

    //Autowire the UserService

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    //CreateUser
    //@RequestBody
    //@PostMapping
    @PostMapping("/users")
    public User createUser(@RequestBody User user){
        return userService.createUser(user);
    }

    //getUserById
    @GetMapping("/users/{id}")
    public Optional<User> getUserById(@PathVariable("id") Long id){
        return userService.getUserById(id);
    }

    //updateUserById
    @PutMapping("/users/{id}")
    public User updateUserById(@PathVariable("id") Long id, @RequestBody User user){
        return userService.updateUserById(id, user);
    }

    //deleteUserById
    @DeleteMapping("/users/{id}")
    public void deleteUserById(@PathVariable("id") Long id) {
        userService.deleteUserById(id);
    }

    //getUserByUserName
    @GetMapping("/users/byusername/{userName}")
    public User getUserByUserName(@PathVariable("userName") String userName) {
        return userService.getUserByUserName(userName);
    }



}
