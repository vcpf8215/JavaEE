package com.vcpf.jee202405110414.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Emp {

    private String id;
    private String name;
    private Double salary;
    private Integer age;
}