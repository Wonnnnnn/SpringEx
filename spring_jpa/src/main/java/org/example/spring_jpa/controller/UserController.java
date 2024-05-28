package org.example.spring_jpa.controller;

import org.example.spring_jpa.entity.User;
import org.example.spring_jpa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/users")
public class UserController {
  private final UserService userService;

  @Autowired
  public UserController(UserService userService) {
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
