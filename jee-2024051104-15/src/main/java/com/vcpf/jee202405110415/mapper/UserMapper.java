package com.vcpf.jee202405110415.mapper;

import com.vcpf.jee202405110415.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 用户信息表 Mapper 接口
 * </p>
 *
 * @author vcpf
 * @since 2026-04-20
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
