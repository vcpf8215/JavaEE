package com.vcpf.iocdemo;

import com.vcpf.iocdemo.entity.Person;
import com.vcpf.iocdemo.hangout.hangoutway.Bike;
import com.vcpf.iocdemo.hangout.hangoutway.Car;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class TestApplication implements CommandLineRunner {
    @Autowired
    private Person person;
    @Autowired
    private Car car;
    @Autowired
    private Bike bike;

    public static void main(String[] args) {
        SpringApplication.run(TestApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        person.setName("小明").setDriveable(car);
        log.info("人物：{}", person.getName());
        person.hangOut();
    }
}
