package org.example.ditest.service;

import org.example.ditest.dto.LoginDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class LoginServiceTest {
    @Autowired
    private LoginService loginService;

    @Test
    void loginprocess() {
        LoginDTO loginDTO = new LoginDTO("test1","qwert");
        boolean b = loginService.loginProcess(loginDTO);
        assertThat(b).isEqualTo(true);
    }
}