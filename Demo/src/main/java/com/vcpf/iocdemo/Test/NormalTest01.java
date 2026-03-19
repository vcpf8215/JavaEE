package com.vcpf.iocdemo.Test;

import com.vcpf.iocdemo.entity.Person;
import com.vcpf.iocdemo.hangout.Driveable;
import com.vcpf.iocdemo.hangout.hangoutway.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@Slf4j
public class NormalTest01 {
    private String name;
    private Person person;

    @BeforeEach
    public void init() {
        name = "小明";
        log.info("改进测试开始：{}要出去浪", name);
    }

    @Test
    public void test01() {
        Driveable tool = new Bike();
        person = new Person(name, tool);
        person.hangOut();
    }

    @Test
    public void test02() {
        Driveable tool = new Car();
        person = new Person(name, tool);
        person.hangOut();
    }

    @Test
    public void test03() {
        Driveable tool = new Train();
        person = new Person(name, tool);
        person.hangOut();
    }

    @Test
    public void test04() {
        Driveable tool = new AirPlane();
        person = new Person(name, tool);
        person.hangOut();
    }

    @Test
    public void test05() {
        Driveable tool = new Ship();
        person = new Person(name, tool);
        person.hangOut();
    }
}
