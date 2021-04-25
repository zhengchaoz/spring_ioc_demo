package cn;

import cn.service.UserService;
import cn.service.impl.UserServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @user 郑超
 * @date 2021/4/25
 */
public class TestAop {

    @Test
    public void test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        // 要用接口，不能用实现类
        UserService userService = context.getBean("userService", UserService.class);
        userService.add();
    }

}
