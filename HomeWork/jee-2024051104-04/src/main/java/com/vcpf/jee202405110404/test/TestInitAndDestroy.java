package com.vcpf.jee202405110404.test;
import com.vcpf.jee202405110404.config.BeanInitDestroyConfig;
import com.vcpf.jee202405110404.service.MyService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;



public class TestInitAndDestroy {
	public static void main(String[] args) {
		//初始化Spring容器ApplicationContext，以配置类形式拿到容器
		AnnotationConfigApplicationContext appCon = 
			new AnnotationConfigApplicationContext(BeanInitDestroyConfig.class);

		// 获取特定配置类初始的Bean对象
		System.out.println("获得对象前");
		MyService ms = appCon.getBean(MyService.class);
		System.out.println("获得对象后" + ms);

		appCon.close();
	}
}