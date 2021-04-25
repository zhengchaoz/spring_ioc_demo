package cn.jt.config;

import cn.jt.pojo.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @user 郑超
 * @date 2021/4/23
 */
@Configuration// 相当于application.xml
@ComponentScan("cn.jt")// 包扫描的路径
@PropertySource(value = "classpath:user.properties", encoding = "UTF-8")// 加载指定的.properties文件
public class AppConfig {

    @Value("${user.id}")
    private int id;
    @Value("${user.name}")
    private String name;

    @Bean// <bean id="user" class="cn.jt.pojo.User"/>
    public User getUser() {
        return new User(id, name);
    }

}
