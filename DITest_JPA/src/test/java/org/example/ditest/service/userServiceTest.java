package org.example.ditest.service;

import org.example.ditest.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
@Transactional
class userServiceTest {
    @Autowired
    private UserService userService;

//    @Autowired
//    private static Assertions;

    @Test
    void addUser() {
        User user = new User(2, "test2","qwert","test2");
        User savedUser = userService.addUser(user);
        User finduser = userService.getOneUserByUserId("test2");
        assertThat(savedUser.getUserId()).isEqualTo(finduser.getUserId());
    }
}