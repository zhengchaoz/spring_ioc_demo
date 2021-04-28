package cn.demo;

import cn.demo.pojo.Dept;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest// 在执行测试方法时启动Spring容器
class SpringbootDemo01ApplicationTests {

    @Autowired
    Dept dept;

    @Test
    void contextLoads() {
        System.out.println(dept);
    }

}
