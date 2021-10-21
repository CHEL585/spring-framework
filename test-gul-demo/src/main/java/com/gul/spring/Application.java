package com.gul.spring;

import com.gul.spring.bean.A;
import com.gul.spring.config.Config;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Map;
import java.util.Set;

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

		A a=context.getBean(A.class);
		Map<String, Set<String>> containedBeanMap = context.getDefaultListableBeanFactory().getContainedBeanMap();
		Map<String, Set<String>> dependentBeanMap = context.getDefaultListableBeanFactory().getDependentBeanMap();
		Map<String, Set<String>> dependenciesForBeanMap = context.getDefaultListableBeanFactory().getDependenciesForBeanMap();
		containedBeanMap.forEach((k,v)->{
			System.out.println(String.format("containedBeanMap 名称:%s,value:%s",k,v));
		});
		dependentBeanMap.forEach((k,v)->{
			System.out.println(String.format("dependentBeanMap 名称:%s,value:%s",k,v));
		});
		dependenciesForBeanMap.forEach((k,v)->{
			System.out.println(String.format("dependenciesForBeanMap 名称:%s,value:%s",k,v));
		});

	}
}
