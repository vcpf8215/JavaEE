package com.vcpf.jee202405110405.test;

import com.vcpf.jee202405110405.dao2.TestDao2;
import com.vcpf.jee202405110405.dao2.TestDaoImpl2;

public class AOP2Test {

	public static void main(String[] args) {

		TestDao2 testDao = new TestDaoImpl2();
		//执行方法
		testDao.save();
		System.out.println("================");
		testDao.modify();
		System.out.println("================");
		testDao.delete();

	}
}