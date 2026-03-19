package com.vcpf.iocdemo.hangout.hangoutway;

import com.vcpf.iocdemo.hangout.Driveable;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Train implements Driveable {
    @Override
    public void drive() {
        log.info("坐火车出去浪~");
    }
}
