package com.vcpf.emsdemo.dao;

import com.vcpf.emsdemo.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserDaoTest {

    @Autowired
    private UserDao userDao;

    @Test
    void insert() {
        // 构造数据
        User u =new User();
        u.setId(UUID.randomUUID().toString()).setPassword("111111");
        u.setGender("男").setRealname("郑测试").setUsername("cszheng");
        // 入库数据
        userDao.insertUser(u);
        // 完成
    }
}