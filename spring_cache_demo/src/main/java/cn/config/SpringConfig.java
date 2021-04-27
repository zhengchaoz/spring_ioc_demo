package cn.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @user 郑超
 * @date 2021/4/27
 */
@Configuration
@ComponentScan("cn")
@EnableAspectJAutoProxy
public class SpringConfig {
}
