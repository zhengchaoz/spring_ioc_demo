package com.tedu.dao;

import org.springframework.stereotype.Component;

/**
 * @Component注解：用于标记此类会被Spring IoC容器扫描配置为Bean
 * @Component("userDao"):其中配置的“userDao”将作为Bean的名称，也可以不指定
 *                       如果不指定，IoC容器会将类名第一个字母小写，其余不变作为bean的名称
 * @author Administrator
 *
 */
@Component("userDao")
public class UserDao {

}
