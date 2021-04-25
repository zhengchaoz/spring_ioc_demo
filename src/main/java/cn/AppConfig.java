package cn;

import cn.di.UserDI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @user 郑超
 * @date 2021/4/22
 */
@Configuration
//@ComponentScan("扫描包") 相当于<context:component-scan base-package="包名"/>
//@Import("配置文件名") 相当于<import resource=""/>
public class AppConfig {

    @Bean
    public UserDI getUserDI() {
        return new UserDI();
    }

}
