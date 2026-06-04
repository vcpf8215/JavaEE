package com.vcpf.emsdemo.service.Impl;

import com.vcpf.emsdemo.dao.UserDao;
import com.vcpf.emsdemo.entity.User;
import com.vcpf.emsdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    public void save(User user) throws Exception {
        userDao.insertUser(user);
    }

    @Override
    public User findUserByUsernameAndPassword(String username, String password) {
        return userDao.selectUserByNameAndPassword(username,password);
    }
}
