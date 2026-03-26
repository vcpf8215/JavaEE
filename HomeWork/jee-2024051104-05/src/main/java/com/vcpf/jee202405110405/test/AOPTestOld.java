package com.vcpf.jee202405110405.test;

import com.vcpf.jee202405110405.dao.TestDao;
import com.vcpf.jee202405110405.dao.TestDaoImpl;

public class AOPTestOld {
    public static void main(String[] args) {
        TestDao testDao = new TestDaoImpl();
        //执行方法
        testDao.save();
        System.out.println("================");
        testDao.modify();
        System.out.println("================");
        testDao.delete();

    }
}
