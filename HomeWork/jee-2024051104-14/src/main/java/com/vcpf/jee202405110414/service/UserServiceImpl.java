package com.vcpf.jee202405110414.service;

import com.vcpf.jee202405110414.dao.UserDao;
import com.vcpf.jee202405110414.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDao userDao;
    @Override
    public void save(User user) throws Exception {
        userDao.insertObj(user);
    }

    @Override
    public User findUserByUsernameAndPassword(String username, String password) {
        return userDao.selectUserByUsernameAndPassword(username,password);
    }
}
