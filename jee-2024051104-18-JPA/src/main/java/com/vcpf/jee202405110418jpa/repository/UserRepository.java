package com.vcpf.jee202405110418jpa.repository;

import com.vcpf.jee202405110418jpa.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

/**
 * 用户持久化接口继承
 *      补充实现了几个核心方法
 *      1. 按名查询
 *      2. 按名分页查询
 *      3. 用JPQL语法查询
 *      4. 用原生SQL语法查询
 *  几个注解的使用
 *      @Transactional 声明一个方法或类需要在事务环境中执行
 *      @Modifying 声明这是一个修改操作【jpa默认是只读操作】
 *      @Query 让开发者能够自定义 SQL 或 JPQL（Java Persistence Query Language）查询语句，
 *              从而实现更为灵活和复杂的数据库查询操作。
 */
public interface UserRepository extends JpaRepository<User,Integer> {
    List<User> findByNameContaining(String name);

    Page<User> findByNameContaining(String name, Pageable pageable);

    @Query("select u from User u where u.birthDay = ?1")
    List<User> findByBirthDay(LocalDate birthDay);

    @Query(value = "select * from user where birth_day =:birthDay",nativeQuery = true)
    List<User> findByBirthDayNative(@Param("birthDay") String birthDay);

    @Modifying
    @Transactional
    @Query(value = "delete from User")
    int delete();
}
