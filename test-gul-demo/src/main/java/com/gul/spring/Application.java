package com.gul.spring;

import com.gul.spring.bean.TestBean;
import com.gul.spring.config.Config;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description TODO
 * @Date 2021/4/13 12:36
 * @Created by gul
 */
public class Application {
	public static void main(String[] args) {
		// 我们基于注解的方式
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
//		// 如果基于XML文件配置，则也可以如下：
//		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
//
		TestBean testBean=context.getBean(TestBean.class);
		testBean.print();
	}
}
