package com.vcpf.jee202405110414.service;

import com.vcpf.jee202405110414.entity.Emp;

import java.util.List;

public interface EmpService {
    List<Emp> findAll();

    void save(Emp emp);

    void alter(Emp emp);

    Emp findEmpById(String id);

    void remove(String id);
}
