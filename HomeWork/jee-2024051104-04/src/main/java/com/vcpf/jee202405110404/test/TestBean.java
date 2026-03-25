package com.vcpf.jee202405110404.test;
import com.vcpf.jee202405110404.Bean.BeanClass;
import com.vcpf.jee202405110404.config.JavaConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class TestBean {

	// 直接main驱动
	public static void main(String[] args) {
		// 初始化Spring容器ApplicationContext，直接使用配置类做初始化
		// 开启容器
		AnnotationConfigApplicationContext appCon = 
			new AnnotationConfigApplicationContext(JavaConfig.class);

		// 各种方式获取bean，不同获取方式，获取的是不同的bean，注意观察它的hash码
		BeanClass b1 = (BeanClass)appCon.getBean("beanClass");
		System.out.println(b1+ b1.message);
		BeanClass b2 = (BeanClass)appCon.getBean("beanStaticFactory");
		System.out.println(b2+ b2.message);
		BeanClass b3 = (BeanClass)appCon.getBean("beanInstanceFactory");
		System.out.println(b3+ b3.message);

		// 关闭容器
		appCon.close();
	}
}