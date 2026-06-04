package com.vcpf.emsdemo.service;

import com.vcpf.emsdemo.entity.Emp;

import java.util.List;

public interface EmpService {

    List<Emp> findAll();

    void save(Emp emp);

    void alter(Emp emp);

    Emp findEmpById(String id);

    void remove(String id);

}