package com.vcpf.jee202405110414.dao;

import com.vcpf.jee202405110414.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserDao extends BaseDao<User,String>{

    @Select(" select * from tb_user where username=#{username} and password=#{password} ")
    User selectUserByUsernameAndPassword(String username, String password);
}
