package cn.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @user 郑超
 * @date 2021/4/26
 */
@Configuration
@ComponentScan("cn")
@EnableAspectJAutoProxy// 启动AOP注解，创建代理对象（默认使用JDK动态代理）
//@EnableAspectJAutoProxy(proxyTargetClass = true)// 强制启用cglib动态代理
public class SpringConfig {
}
