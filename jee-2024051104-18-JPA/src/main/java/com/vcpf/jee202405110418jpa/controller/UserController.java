package com.vcpf.jee202405110418jpa.controller;

import com.vcpf.jee202405110418jpa.entity.User;
import com.vcpf.jee202405110418jpa.repository.UserRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

/**
 * 知识点：
 *      1. java.util.Optional 是 Java 8 引入的一个容器
 *          类，它的主要作用是为了避免空指针异常（NullPointerException），
 *          更优雅地处理可能为 null 的值。findById 返回的就是这样的对象
 *      2. knife4j文档生成
 *      3. RestFul的WEB接口，返回JSON
 *      4. 注入持久化对象，操作user表
 *
 * @Document http://localhost:8080/springboot/doc.html  查看文档
 */
@Api(tags = "用户管理WEB接口")
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @ApiOperation(value = "根据id获取用户信息")
    @GetMapping("/{id}")
    public User get(@PathVariable int id) {
        return userRepository.findById(id).get();
    }

    @ApiOperation(value = "根据名字获取用户信息")
    @GetMapping("/name")
    public List<User> getByName(String name) {
        return userRepository.findByNameContaining(name);
    }

    @ApiOperation(value = "根据生日获取用户信息")
    @GetMapping("/birthday")
    public List<User> getByBirthDay(String birthDay) {
        return userRepository.findByBirthDay(LocalDate.parse(birthDay));
    }

    @ApiOperation(value = "根据生日获取用户信息（native sql）")
    @GetMapping("/native/birthday")
    public List<User> getByBirthDayNative(String birthDay) {
        return userRepository.findByBirthDayNative(birthDay);
    }


    /**
     * 获取所有数据，按指定列进行排序，获取排序后的列表数据
     * @param property 排序列
     * @param direction 默认升序
     * @param page 首页
     * @param size 10条记录
     * @return
     */
    @ApiOperation(value = "获取用户列表（分页）")
    @GetMapping
    public Page<User> list(@RequestParam(defaultValue = "id") String property,
                           @RequestParam(defaultValue = "ASC") Sort.Direction direction,
                           @RequestParam(defaultValue = "0") Integer page,
                           @RequestParam(defaultValue = "10") Integer size) {
        // 分页对象
        Pageable pageable = PageRequest.of(page, size, direction, property);
        // 全部查询
        return userRepository.findAll(pageable);
    }

    /**
     * 条件查询获取数据，按指定列进行排序，获取排序后的列表数据
     * @param name
     * @param property
     * @param direction
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value = "根据名字查询（分页）")
    @GetMapping("/page/{name}")
    public Page<User> queryByName(@PathVariable String name,
                                  @RequestParam(defaultValue = "id") String property,
                                  @RequestParam(defaultValue = "ASC") Sort.Direction direction,
                                  @RequestParam(defaultValue = "0") Integer page,
                                  @RequestParam(defaultValue = "10") Integer size) {
        // 分页对象
        Pageable pageable = PageRequest.of(page, size, direction, property);
        // 条件查询
        return userRepository.findByNameContaining(name, pageable);
    }

    @ApiOperation(value = "创建用户")
    @PostMapping
    @Transactional
    public User create(@RequestBody User user) {
        // 创建和更新底层是调同一个方法，不存在，则新增；存在，则更新
        return userRepository.save(user);
    }

    @ApiOperation(value = "更新用户")
    @PutMapping
    public User update(@RequestBody User user) {
        // 创建和更新底层是调同一个方法，不存在，则新增；存在，则更新
        return userRepository.save(user);
    }

    @ApiOperation(value = "删除用户")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        userRepository.deleteById(id);
    }

    @ApiOperation(value = "删除所有用户")
    @DeleteMapping
    public int delete() {
        return userRepository.delete();
    }

}