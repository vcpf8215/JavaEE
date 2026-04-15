package com.vcpf.jee202405110411.Service;

import com.vcpf.jee202405110411.Repository.UserRepository;
import com.vcpf.jee202405110411.entity.MyUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author vcpf
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired//依赖注入数据访问层
    private UserRepository userRepository;

    // 初始化数据
    @Override
    public void saveAll() {
        MyUser mu1 = new MyUser();
        mu1.setUname("陈恒1");
        mu1.setGender("男");
        mu1.setAge(88);
        MyUser mu2 = new MyUser();
        mu2.setUname("陈恒2");
        mu2.setGender("女");
        mu2.setAge(18);
        MyUser mu3 = new MyUser();
        mu3.setUname("陈恒3");
        mu3.setGender("男");
        mu3.setAge(99);
        List<MyUser> users = new ArrayList<MyUser>();
        users.add(mu1);
        users.add(mu2);
        users.add(mu3);
        //调用父接口中的方法saveAllAndFlush
        userRepository.saveAllAndFlush(users);
    }

    @Override
    public List<MyUser> findAll() {
        //调用父接口中的方法findAll
        return userRepository.findAll();
    }

    @Override
    public MyUser findByUname(String uname) {
        return userRepository.findByUname(uname);
    }

    @Override
    public List<MyUser> findByUnameLike(String uname) {
        return userRepository.findByUnameLike("%" + uname + "%");
    }

    @Override
    public MyUser getOne(int id) {
        //调用父接口中的方法getReferenceById
        return userRepository.getReferenceById(id);
    }
}
