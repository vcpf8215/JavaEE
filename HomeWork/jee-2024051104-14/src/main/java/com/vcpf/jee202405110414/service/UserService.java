package com.vcpf.jee202405110414.service;

import com.vcpf.jee202405110414.entity.User;

public interface UserService {
    void save(User user) throws Exception;

    User findUserByUsernameAndPassword(String username, String password);
}
