package com.tedu;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.tedu.pojo.User;

/* 
 * @Configuration注解：
 * 			告诉spring这是一个java配置文件(类)，spring会根据这个文件生成IoC容器
 * 			AppConfig（java配置类）== beans.xml配置文件
 * @ComponentScan注解：让Spring进行扫描，默认只扫描此类所在的包及其子包
 * @ComponentScan("com.tedu.*")：也可以指定所扫描的包(com.tedu包及其子包)
 * @ComponentScan(basePackages = {"com.tedu.dao","com.tedu.service"})：
 *  当需要扫描的包有多个时，可以指定多个包。
 */
@Configuration
@ComponentScan
public class AppConfig {

	/*
	 * @Bean注解：将当前方法返回的POJO装配到IoC容器中（作用等同于bean标签）
	 * name属性用于定义这个bean的名称，如果没有配置将会默认使用方法名作为名字 类型为方法的返回值类型
	 */
//	@Bean(name = "user")
//	public User getUser() {
//		User user = new User();
//		user.setName("刘德华");
//		user.setAge(20);
//		return user;
//	}

}
