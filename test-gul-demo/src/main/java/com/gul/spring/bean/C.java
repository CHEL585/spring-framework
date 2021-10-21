package com.gul.spring.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Description TODO
 * @Date 2021/10/21 15:13
 * @Created by gul
 */
@Component
public class C {
	@Autowired
	private A a;
}
