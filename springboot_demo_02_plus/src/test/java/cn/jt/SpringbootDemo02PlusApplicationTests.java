package cn.jt;

import cn.jt.mapper.DemoUserMapper;
import cn.jt.pojo.DemoUser;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.StringUtils;

import java.util.List;

@SpringBootTest
class SpringbootDemo02PlusApplicationTests {

    @Autowired
    private DemoUserMapper mapper;

    @Test
    void contextLoads() {
        mapper.findAll().forEach(System.out::println);
    }

    @Test
    void testFindById() {
        DemoUser demoUser = mapper.selectById(1);
        System.out.println(demoUser);
    }

    @Test
    void testModelById() {
        System.out.println(new DemoUser().setId(231).selectById());
    }

    @Test
    void testModelUpdateById() {
        System.out.println(new DemoUser().setId(231).setName("仙姑").updateById());
    }

    @Test
    void testFindByBetweenAge() {
        mapper.selectList(new QueryWrapper<DemoUser>()
                .between("age", "1500", "3100")).forEach(System.out::println);
    }

    @Test
    void testSelectList() {
//        mapper.selectList(new QueryWrapper<DemoUser>()
//                .eq(false, "sex", "女").eq(true, "name", "白骨精"))
//                .forEach(System.out::println);
//        mapper.selectList(new QueryWrapper<DemoUser>()
//                .gt("age", 18).eq("sex", "女"))
//                .forEach(System.out::println);
//        mapper.selectList(new QueryWrapper<DemoUser>()
//                .like("name", "精")).forEach(System.out::println);
//        mapper.selectList(new QueryWrapper<DemoUser>()
//                .eq("sex", "男").orderByDesc("id"))
//                .forEach(System.out::println);
//        mapper.selectList(new QueryWrapper<DemoUser>()
//                .in("id", 1, 3, 5, 7, 9))
//                .forEach(System.out::println);
//        mapper.selectObjs(new QueryWrapper<DemoUser>()
//                .eq("sex", "男")).forEach(System.out::println);
//        mapper.selectList(new QueryWrapper<DemoUser>()
//                .select("sex", "name")).forEach(System.out::println);
//        mapper.selectMaps(new QueryWrapper<DemoUser>()
//                .select("sex", "name")).forEach(System.out::println);
        System.out.println(mapper.update(new DemoUser().setName("哈哈").setSex("女"),
                new UpdateWrapper<DemoUser>().eq("name", "仙姑")));
    }

}
