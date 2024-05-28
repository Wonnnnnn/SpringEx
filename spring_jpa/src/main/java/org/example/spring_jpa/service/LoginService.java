package org.example.spring_jpa.service;


import lombok.AllArgsConstructor;
import org.example.spring_jpa.dto.LoginDTO;
import org.example.spring_jpa.entity.User;
import org.example.spring_jpa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Service
@Transactional(readOnly = true)
@AllArgsConstructor
public class LoginService {
  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;

  public boolean loginProcess(LoginDTO loginDto) {
    User user = userRepository.findByUserId(loginDto.getUserId()).get();
    if(user != null && user.checkPassword(loginDto.getPassword(), passwordEncoder)) {
      return true;
    } else {
      return false;
    }
  }
}
