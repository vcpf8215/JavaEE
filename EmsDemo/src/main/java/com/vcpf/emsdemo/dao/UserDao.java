package com.vcpf.emsdemo.dao;


import com.vcpf.emsdemo.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserDao extends BaseDao<User, String> {

    void insertUser(User user);
    User selectUserByNameAndPassword(@Param("username") String username,
                                     @Param("password") String password);
}