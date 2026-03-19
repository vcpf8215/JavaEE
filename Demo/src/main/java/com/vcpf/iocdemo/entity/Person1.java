package com.vcpf.iocdemo.entity;

import com.vcpf.iocdemo.hangout.Driveable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Person1 {

    // 多态接口，描述具体的工具属性
    private Driveable driveable;

    // 出去逛具体的逛法调用
    public void hangOut() {
        driveable.drive();
    }
}
