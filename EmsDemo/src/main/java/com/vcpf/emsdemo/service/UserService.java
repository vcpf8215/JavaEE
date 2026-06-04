package com.vcpf.emsdemo.service;


import com.vcpf.emsdemo.entity.User;

public interface UserService {
    void save(User user) throws Exception;
    User findUserByUsernameAndPassword(String username, String password);
}