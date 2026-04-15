package com.vcpf.jee202405110414.dao;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.vcpf.jee202405110414.entity.User;

import java.util.UUID;

@Slf4j
@SpringBootTest
class UserDaoTest {
    @Autowired
    private UserDao userDao;

    @Test
    void insertUser() {
//        构造数据
        User user = new User();
        user.setId(UUID.randomUUID().toString()).setPassword("111111");
        user.setGender("男").setRealname("张三").setUsername("Nkl");

        userDao.insertObj(user);
    }

    @Test
    void selectUserByUsernameAndPassword() {
        User user = userDao.selectUserByUsernameAndPassword("Nkl","111111");
        log.info(user.toString());
    }
}