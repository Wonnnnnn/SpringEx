package org.example.ditest.service;

import lombok.NoArgsConstructor;
import org.example.ditest.dto.LoginDTO;
import org.example.ditest.entity.User;
import org.example.ditest.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@AllArgsConstructor
public class LoginService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public boolean loginProcess(LoginDTO loginDto) {
        User user = userRepository.findByUserId(loginDto.getUserId()).get();
        // checkpassword
        if(user != null && user.checkPassword(loginDto.getPassword(), passwordEncoder)) {
            return true;
        } else {
            return false;
        }
    }
}
