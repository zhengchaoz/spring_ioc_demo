package com.tedu;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.tedu.pojo.User;

/* 
 * @Configurationע�⣺
 * 			����spring����һ��java�����ļ�(��)��spring���������ļ�����IoC����
 * 			AppConfig��java�����ࣩ== beans.xml�����ļ�
 * @ComponentScanע�⣺��Spring����ɨ�裬Ĭ��ֻɨ��������ڵİ������Ӱ�
 * @ComponentScan("com.tedu.*")��Ҳ����ָ����ɨ��İ�(com.tedu�������Ӱ�)
 * @ComponentScan(basePackages = {"com.tedu.dao","com.tedu.service"})��
 *  ����Ҫɨ��İ��ж��ʱ������ָ���������
 */
@Configuration
@ComponentScan
public class AppConfig {

	/*
	 * @Beanע�⣺����ǰ�������ص�POJOװ�䵽IoC�����У����õ�ͬ��bean��ǩ��
	 * name�������ڶ������bean�����ƣ����û�����ý���Ĭ��ʹ�÷�������Ϊ���� ����Ϊ�����ķ���ֵ����
	 */
//	@Bean(name = "user")
//	public User getUser() {
//		User user = new User();
//		user.setName("���»�");
//		user.setAge(20);
//		return user;
//	}

}
