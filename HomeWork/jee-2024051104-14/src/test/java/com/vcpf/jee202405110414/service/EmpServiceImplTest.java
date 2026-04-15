package com.vcpf.jee202405110414.service;

import com.vcpf.jee202405110414.entity.Emp;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EmpServiceImplTest {
    @Autowired
    private EmpService empService;

    @Test
    void insert() {
        Emp emp = new Emp();
        emp.setId("a0001").setName("vcpf").setAge(18).setSalary(9000.0);
        try {
            empService.save(emp);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}