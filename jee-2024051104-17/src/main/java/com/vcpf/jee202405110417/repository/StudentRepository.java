package com.vcpf.jee202405110417.repository;
import java.util.List;

import com.vcpf.jee202405110417.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

public interface StudentRepository extends JpaRepository<Student, Integer>{
    /**
     * 自定义接口查询方法，暴露为REST资源
     */
    @RestResource(path = "snameStartsWith", rel = "snameStartsWith")
    List<Student> findBySnameStartsWith(@Param("sname") String sname);
}