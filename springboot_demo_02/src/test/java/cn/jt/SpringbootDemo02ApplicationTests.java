package cn.jt;

import cn.jt.mapper.DemoUserMapper;
import cn.jt.pojo.DemoUser;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootDemo02ApplicationTests {

    @Autowired
    private DemoUserMapper mapper;

    @Test
    void contextLoads() {
        mapper.findAll().forEach(System.out::println);
    }

    @Test
    void testFindById() {
        System.out.println(mapper.getClass());
        System.out.println(mapper.findById(231));
    }

    @Test
    void testAddDemoUser() {
        int i = mapper.insert(new DemoUser().setName("郑超").setAge(0).setSex("男"));
        System.out.println(i);
    }

    @Test
    void testUpdateDemoUser() {
        int i = mapper.update(new DemoUser().setId(231).setName("郑超123").setAge(204).setSex("男"));
        System.out.println(i);
    }

    @Test
    void testDeleteById() {
        int i = mapper.deleteById(232);
        System.out.println(i);
    }

}
