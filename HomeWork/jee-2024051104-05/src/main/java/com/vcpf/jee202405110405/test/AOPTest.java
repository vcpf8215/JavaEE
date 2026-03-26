package com.vcpf.jee202405110405.test;

import com.vcpf.jee202405110405.config.AspectjAopConfig;
import com.vcpf.jee202405110405.dao.TestDao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AOPTest {
	public static void main(String[] args) {
		// 拿到容器：初始化Spring容器ApplicationContext
		AnnotationConfigApplicationContext appCon =
			new AnnotationConfigApplicationContext(AspectjAopConfig.class);
		// 拿到组件：从容器中，获取增强后的目标对象
		TestDao testDaoAdvice = appCon.getBean(TestDao.class);
		// 使用组件：做业务，执行方法
		testDaoAdvice.save();
		System.out.println("================");
		testDaoAdvice.modify();
		System.out.println("================");
		testDaoAdvice.delete();

        // 关闭容器
		appCon.close();
	}
}