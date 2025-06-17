package com.ankur.SpringSecEx.controller;

import com.ankur.SpringSecEx.model.Users;
import com.ankur.SpringSecEx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/register")
    public Users register(@RequestBody Users user){
        return userService.register(user);
    }

    @GetMapping("/login")
    public String login(@RequestBody Users user){
        return userService.verify(user);
    }

    @GetMapping("/students/{id}")
    public Users getUser(@PathVariable(value = "id") String id){
        return userService.getUser(id);
    }

}
