package com.vcpf.jee202405110409.service;


import com.vcpf.jee202405110409.entity.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class UserService {

    // 模拟内存数据：用户表，用户集合数据
    private List<User> users;

    // 只初始化一个用户
    public UserService() {
        users = new ArrayList<User>();
        User user = new User();
        user.setName("fhzheng");
        user.setPassword("123456");
        users.add(user);
    }

    // 完成CRUD业务
    // 添加
    public boolean addUser(User user) {
        try {
            users.add(user);
            return true;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // 更新
    public boolean updateUser(User user) {
        try {
            // 找得到才能更新
            for (int i = 0; i < users.size(); i++) {
                if (users.get(i).getName() == user.getName()) {
                    users.set(i,user);
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // 删除
    public boolean deleteUser(User user) {
        try {
            // 找得到才能删除
            for (int i = 0; i < users.size(); i++) {
                if (users.get(i).getName() == user.getName()) {
                    users.remove(i);
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // 列表
    public List<User> getUsers() {
        return users;
    }

    // 按Id取出一个
    public User getUser(int id) {
        return users.get(id);
    }

    // 按名取首个匹配的用户，一个
    public User getUser(User user) {
        for (User user1 : users) {
            if (Objects.equals(user1.getName(), user.getName())) {
                return user1;
            }
        }
        return null;
    }
}
