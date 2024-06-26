package org.example.spring_jpa.controller;

import jakarta.servlet.http.HttpSession;
import org.example.spring_jpa.dto.LoginDTO;
import org.example.spring_jpa.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping
public class LoginController {
  private final LoginService loginService;

  @Autowired
  public LoginController(LoginService loginService) {
    this.loginService = loginService;
  }

  @GetMapping("/login")
  public String login() {
    return "/login/loginForm";
  }

  @PostMapping("/login")
  public String login(@ModelAttribute LoginDTO loginDto) {
    if(loginService.loginProcess(loginDto))
      return "redirect:/posts";
    return "redirect:/login";
  }

  @GetMapping("/logout")
  public String logout(HttpSession session) {
    session.invalidate();
    return "redirect:/login";
  }
}

