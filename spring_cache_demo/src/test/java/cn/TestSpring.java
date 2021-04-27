package cn;

import cn.config.SpringConfig;
import cn.pojo.User;
import cn.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @user 郑超
 * @date 2021/4/27
 */
public class TestSpring {

    @Test
    public void test(){
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        UserService userService = context.getBean(UserService.class);
        User user = new User(122, "张三丰");
        // 第一次走数据库
        userService.findUserById(user);
        // 第二次走缓存
        userService.findUserById(user);
    }

}
