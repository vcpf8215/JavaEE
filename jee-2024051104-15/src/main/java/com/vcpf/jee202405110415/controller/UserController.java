package com.vcpf.jee202405110415.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.vcpf.jee202405110415.entity.User;
import com.vcpf.jee202405110415.service.UserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 用户信息表 前端控制器
 * </p>
 *
 * @author vcpf
 * @since 2026-04-20
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @ApiOperation(value = "新增用户信息")
    @PostMapping
    public Boolean add(@RequestBody User user) {
        return userService.save(user);
    }

    //    @ApiOperation(value = "按id删除用户信息")
    @ApiOperation(value = "按id删除用户信息", notes = "按库表里的用户id号，删除相应的用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户ID号", required = true, dataType = "String", paramType = "query")
    })
    @DeleteMapping(value = "/{id}")
    public Boolean remove(@PathVariable Integer id) {
        return userService.removeById(id);
    }

    @ApiOperation(value = "修改用户信息")
    @PutMapping
    public Boolean modify(@RequestBody User user) {
        return userService.updateById(user);
    }

    @ApiOperation(value = "按id查询用户信息")
    @GetMapping(value = "/{id}")
    public User get(@PathVariable Integer id) {
        return userService.getById(id);
    }
    /**
     * 先添加分页组件，配置即可使用。
     *
     * 注意参数的意义
     * @param current 每页记录起点
     * @param size 每页大小
     * @return 分页数据集
     */
    @GetMapping
    @ApiOperation("分页查询")
    public Page<User> list(@RequestParam(defaultValue = "1") Integer current,
                           @RequestParam(defaultValue = "10") Integer size) {
        return userService.page(new Page<>(current,size));
    }

    @ApiOperation("按条件查询用户")
    @GetMapping("/users")
    public List<User> getUsers() {
        // 示例：查询id大于4且邮箱包含 [fhzheng] 的用户
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.gt("id", 4).like("email", "fhzheng");
        return userService.getUsersByCondition(queryWrapper);
    }

    @ApiOperation("按条件查询用户1")
    @GetMapping("/users1")
    public List<User> getUsers1() {
        // 示例：查询id大于4且邮箱包含 [zheng] 的用户，写死的条件
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.gt("id", 4).like("email", "zheng");
        return userService.getUsersByCondition(queryWrapper);
    }

    @ApiOperation("按条件查询用户2")
    @GetMapping("/users2")
    public List<User> getUsers2(@RequestParam(defaultValue = "1") Integer id,
                                @RequestParam(defaultValue = "zheng")String email) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.gt("id", id).like("email", email);
        return userService.getUsersByCondition(queryWrapper);
    }
}
