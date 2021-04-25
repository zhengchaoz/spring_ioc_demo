package cn.jt;

import cn.jt.config.AppConfig;
import cn.jt.controller.UserController;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @user 郑超
 * @date 2021/4/22
 */
public class TestSpring {

    @Test
    public void test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        UserController controller = context.getBean("userController", UserController.class);
        System.out.println(controller);
        controller.addUser();
    }

    @Test
    public void testApplication(){
        ApplicationContext context = new AnnotationConfigApplicationContext("cn.jt");
        UserController controller = context.getBean(UserController.class);
        controller.addUser();
    }

    @Test
    public void testAppConfig(){
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        UserController controller = context.getBean(UserController.class);
        System.out.println(controller);
        controller.addUser();
    }

}
