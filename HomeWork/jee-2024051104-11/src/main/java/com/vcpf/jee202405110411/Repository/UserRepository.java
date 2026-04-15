package com.vcpf.jee202405110411.Repository;

import com.vcpf.jee202405110411.entity.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 持久层
 * 用户数据访问接口
 * 只需要设定接口，Spring Data JPA会自动生成实现类
 * @author vcpf
 */
public interface UserRepository extends JpaRepository<MyUser, Integer> {
    /**
     * 根据用户名查询用户
     * @param uname
     * @return MyUser
     */
    public MyUser findByUname(String uname);
    /**
     * 根据用户名模糊查询用户
     * @param uname
     * @return  MyUser
     */
    public List<MyUser> findByUnameLike(String uname);
}