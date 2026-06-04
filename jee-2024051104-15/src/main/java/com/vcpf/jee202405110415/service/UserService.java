package com.vcpf.jee202405110415.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.vcpf.jee202405110415.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.vcpf.jee202405110415.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 用户信息表 服务类
 * </p>
 *
 * @author vcpf
 * @since 2026-04-20
 */

public interface UserService extends IService<User> {
    List<User> getUsersByCondition(Wrapper<User> queryWrapper);
}
