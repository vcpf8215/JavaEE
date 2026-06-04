package com.vcpf.jee202405110415.service.impl;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.vcpf.jee202405110415.entity.User;
import com.vcpf.jee202405110415.mapper.UserMapper;
import com.vcpf.jee202405110415.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 用户信息表 服务实现类
 * </p>
 *
 * @author vcpf
 * @since 2026-04-20
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> getUsersByCondition(Wrapper<User> queryWrapper) {
        return userMapper.selectList(queryWrapper);
    }
}
