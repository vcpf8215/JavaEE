package com.vcpf.iocdemo.Test;

import com.vcpf.iocdemo.Container;
import com.vcpf.iocdemo.entity.Person;
import com.vcpf.iocdemo.hangout.Driveable;
import com.vcpf.iocdemo.hangout.hangoutway.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@Slf4j
public class IoCTest {
    private Container container;
    private Person person;
    private String name = "小明";

    @BeforeEach
    public void init() {
        container = new Container();
        person = new Person();
        person.setName(name);

        container.put(Bike.class, new Bike());
        container.put(Car.class, new Car());
        container.put(Train.class, new Train());
        container.put(AirPlane.class, new AirPlane());
        container.put(Ship.class, new Ship());

        log.info("测试开始，{}要出去玩", name);
    }

    @Test
    public void test01() {
        Driveable bike = container.getBean(Bike.class);
        person.setDriveable(bike);
        person.hangOut();
    }
    @Test
    public void test02() {
        Driveable car = container.getBean(Car.class);
        person.setDriveable(car);
        person.hangOut();
    }
    @Test
    public void test03() {
        Driveable train = container.getBean(Train.class);
        person.setDriveable(train);
        person.hangOut();
    }
    @Test
    public void test04() {
        Driveable airPlane = container.getBean(AirPlane.class);
        person.setDriveable(airPlane);
        person.hangOut();
    }
    @Test
    public void test05() {
        Driveable ship = container.getBean(Ship.class);
        person.setDriveable(ship);
        person.hangOut();
    }
}
