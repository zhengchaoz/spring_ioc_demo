package com.tedu.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tedu.pojo.User;

public class DITest {

	@Test
	public void testDI() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		User user = (User) ac.getBean("user");
		System.out.println(user);
	}
	
}
