package org.example.spring_jpa.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.spring_jpa.entity.User;
import org.example.spring_jpa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@AllArgsConstructor
public class UserService implements UserDetailsService {
  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;

  public User getOneUserById(Integer id) {
    return userRepository.findById(id).get();
  }

  public User getOneUserByUserId(String userId) {
    return userRepository.findByUserId(userId).get();
  }

  @Override
  public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
    User user = userRepository.findByUserId(userId).get();
    return user;
  }

  @Transactional
  public User addUser(User user) {
    User user1 = user.hashPassword(passwordEncoder);
    return userRepository.save(user1);
  }
}
