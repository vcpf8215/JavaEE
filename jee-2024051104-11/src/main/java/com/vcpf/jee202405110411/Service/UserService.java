package com.vcpf.jee202405110411.Service;

import com.vcpf.jee202405110411.entity.MyUser;

import java.util.List;

/**
 * 用户服务接口 服务层
 * @author vcpf
 */
public interface UserService {
    public void saveAll();
    public List<MyUser> findAll();
    public MyUser findByUname(String uname);
    public List<MyUser> findByUnameLike(String uname);
    public MyUser getOne(int id);
}