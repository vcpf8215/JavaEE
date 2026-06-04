package com.vcpf.emsdemo.service;

import com.vcpf.emsdemo.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    void save() {
        User user = new User();
        user.setId(UUID.randomUUID().toString());
        user.setRealname("郑业务层");
        user.setGender("女");
        user.setUsername("ywzheng").setPassword("888888");
        try {
            userService.save(user);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}