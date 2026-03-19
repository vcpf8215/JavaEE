package com.vcpf.iocdemo.hangout.hangoutway;

import com.vcpf.iocdemo.hangout.Driveable;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class AirPlane implements Driveable {
    @Override
    public void drive() {
        log.info("坐着飞机出去浪~");
    }
}
