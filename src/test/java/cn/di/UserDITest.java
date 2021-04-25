package cn.di;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @user 郑超
 * @date 2021/4/21
 */
public class UserDITest {

    @Test
    public void test() {
        // 加载配置文件，创建Spring容器对象
        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        // 从容器中取出对象
        UserDI user = (UserDI) context.getBean("userDI");
        // 执行方法
        System.out.println(user.toString());
    }

}
