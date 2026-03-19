package com.vcpf.iocdemo.Test;

import com.vcpf.iocdemo.entity.Person;
import com.vcpf.iocdemo.hangout.Driveable;
import com.vcpf.iocdemo.hangout.hangoutway.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@Slf4j
public class NormalTest {
    private Person person;

    @BeforeEach
    public void init() {
        log.info("常规测试开始：");
    }

    @Test
    public void test01() {
        Driveable tool = new Bike();
        person = new Person("xiaoming", tool);
        person.hangOut();
    }

    @Test
    public void test02() {
        Driveable tool = new Car();
        person = new Person("xiaoming", tool);
        person.hangOut();
    }

    @Test
    public void test03() {
        Driveable tool = new Train();
        person = new Person("xiaoming", tool);
        person.hangOut();
    }

    @Test
    public void test04() {
        Driveable tool = new AirPlane();
        person = new Person("xiaoming", tool);
        person.hangOut();
    }

    @Test
    public void test05() {
        Driveable tool = new Ship();
        person = new Person("xiaoming", tool);
        person.hangOut();
    }
}
