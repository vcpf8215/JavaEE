package com.vcpf.jee202405110404.service;

public class MyService {
    public void initService() {
        System.out.println(this.getClass().getName()+"执行自定义的初始化方法");
    }

    public MyService() {
        System.out.println("执行构造方法，创建对象。");
    }

    public void destroyService() {
        System.out.println(this.getClass().getName()+"执行自定义的销毁方法");
    }
}
