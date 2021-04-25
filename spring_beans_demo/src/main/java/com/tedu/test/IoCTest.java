package com.tedu.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.tedu.AppConfig;
import com.tedu.pojo.User;

public class IoCTest {

	@Test
	public void testIoC() {
		ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

		User user = (User) ac.getBean("user");
		System.out.println(user);

		boolean singleton = ac.isSingleton("user");
		System.out.println(singleton);
	}

	/* 2°¢…®√Ë◊∞≈‰Bean */
	@Test
	public void testAnnoTation02() {
		ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
		String[] beanNames = ac.getBeanDefinitionNames();
		Stream.of(beanNames).forEach(System.out::println);

		ArrayList<String> list = new ArrayList<>(Arrays.asList(beanNames));
	}
	
}
