package com.jt;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Arrays;

/**
 * @author 刘昱江
 * 时间 2021/5/11
 */
@SpringBootApplication
@MapperScan("com.jt.mapper")
public class SpringBootRun {

    public static void main(String[] args) {

        ConfigurableApplicationContext run = SpringApplication.run(SpringBootRun.class, args);
        Arrays.stream(run.getBeanDefinitionNames()).forEach(System.out::println);

    }
}
