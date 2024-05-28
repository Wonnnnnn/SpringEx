package com.example.ditest.controller;

import org.example.ditest.entity.User;
import org.example.ditest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class userController {
    private final UserService userService;

    @Autowired
    public userController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{userId}")
    public User getUserInfo(@PathVariable("userId") String userId) {
        return userService.getOneUserByUserId(userId);
    }

    @GetMapping("/new")
    public String createUser() {
        return "login/register";
    }

    @PostMapping("/new")
    public String createUser(@ModelAttribute User user) {
        userService.addUser(user);
        return "redirect:/login";
    }
}
