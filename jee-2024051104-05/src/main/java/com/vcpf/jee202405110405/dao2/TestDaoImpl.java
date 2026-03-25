package com.vcpf.jee202405110405.dao2;

import org.springframework.stereotype.Repository;

@Repository("testDao")
public class TestDaoImpl implements TestDao {
    @Override
    public void save() {
        System.out.println("核心业务===>   save 执行保存");
    }

    @Override
    public void modify() {
        System.out.println("核心业务===>   modify 修改完成");
    }

    @Override
    public void delete() {
        try {
            int i=1/0;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {

        }
        System.out.println("核心业务===>   delete 删除完成");
    }
}
