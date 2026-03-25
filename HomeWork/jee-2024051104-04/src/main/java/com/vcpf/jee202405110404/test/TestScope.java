package com.vcpf.jee202405110404.test;
import com.vcpf.jee202405110404.config.ScopeConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.vcpf.jee202405110404.service.PrototypeService;
import com.vcpf.jee202405110404.service.SingletonService;

/**
 * 测试容器中，bean的作用域
 */
public class TestScope {
	public static void main(String[] args) {

		// 初始化Spring容器ApplicationContext
		// 按配置类来初始化容器，得到容器，打开容器
		AnnotationConfigApplicationContext appCon = 
			new AnnotationConfigApplicationContext(ScopeConfig.class);

		// 获取单例模式下的bean，不论多少个，均是同一个
		SingletonService ss1 = appCon.getBean(SingletonService.class);
		SingletonService ss2 = appCon.getBean(SingletonService.class);
		System.out.println(ss1);
		System.out.println(ss2);

		// 获取原型模式下的bean，每次获取的是不一样的bean
		PrototypeService ps1 = appCon.getBean(PrototypeService.class);
		PrototypeService ps2 = appCon.getBean(PrototypeService.class);
		System.out.println(ps1);
		System.out.println(ps2);

		// 关闭容器
		appCon.close();
	}
}