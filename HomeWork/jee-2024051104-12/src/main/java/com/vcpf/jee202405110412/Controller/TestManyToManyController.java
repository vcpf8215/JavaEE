package com.vcpf.jee202405110412.Controller;
import java.util.List;

import com.vcpf.jee202405110412.Service.UserAndAuthorityService;
import com.vcpf.jee202405110412.entity.Authority;
import com.vcpf.jee202405110412.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <pre>
 * 用户和权限是多对多：一个有多个权限，一个权限分给多个人
 * 1. 初始化数据
 * 2. 查询所有：
 *      查用户，带出权限
 *      查权限，带出用户
 * </pre>
 */
@RestController
public class TestManyToManyController {

    @Autowired
    private UserAndAuthorityService userAndAuthorityService;

    // http://localhost:8080/ch6_2/saveManyToMany
    /**
     * 这里的调用完成时，数据库里表的数据会完成初始化
     * 1. 用户表
     * 2. 权限表
     * 3. 用户权限关联表-JPA生成并交给用户实体维护
     * @return
     */
    @GetMapping("/saveManyToMany")
    public String save() {
        userAndAuthorityService.saveAll();
        return "权限和用户保存成功！";
    }

    // http://localhost:8080/ch6_2/findByAuthorityList_id?id=1
    /**
     * 查看，id为1的用户的信息，带出权限信息
     * @param id
     * @return
     */
    @GetMapping("/findByAuthorityList_id")
    public List<User> findByAuthorityList_id(int id) {
        return userAndAuthorityService.findByAuthorityList_id(id);
    }

    // http://localhost:8080/ch6_2/findByAuthorityList_name?name=修改
    /**
     * 查看，权限name为 "修改" 的用户的信息，带出权限信息
     * @param name
     * @return 可能的多个用户
     */
    @GetMapping("/findByAuthorityList_name")
    public List<User> findByAuthorityList_name(String name) {
        return userAndAuthorityService.findByAuthorityList_name(name);
    }

    // http://localhost:8080/ch6_2/findByUserList_id?id=2
    /**
     * 查看，用户id为2的用户的权限信息
     * @param id
     * @return 可能的多个权限
     */
    @GetMapping("/findByUserList_id")
    public List<Authority> findByUserList_id(int id) {
        return userAndAuthorityService.findByUserList_id(id);
    }

    // http://localhost:8080/ch6_2/findByUserList_Username?username=陈伊伊2
    /**
     * 查看，用户名为“陈恒2”用户的权限
     * @param username
     * @return 可能的多个权限
     */
    @GetMapping("/findByUserList_Username")
    public List<Authority> findByUserList_Username(String username) {
        return userAndAuthorityService.findByUserList_Username(username);
    }
}
