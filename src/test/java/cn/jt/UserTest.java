package cn.jt;

import cn.jt.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @user 郑超
 * @date 2021/4/21
 */
public class UserTest {

    @Test
    public void test() {
        // 加载配置文件，创建Spring容器对象
        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        // 从容器中取出对象
        User user = (User) context.getBean("user");
//        User user1 = context.getBean(User.class);
//        User user2 = context.getBean("user", User.class);
        // 执行方法
        user.say();
    }

    @Test
    public void demo() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        // 通过反射创建对象
        Class<?> userClass = Class.forName("cn.jt.pojo.User");
        User user = (User) userClass.newInstance();
        user.say();
    }

    @Test
    public void testPrototype() {
        // 加载配置文件，创建Spring容器对象
        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        // 从容器中取出对象
        context.getBean("user");
        context.getBean("user");
        context.getBean("user");
    }

    @Test
    public void testLifeCycle() {
        // 加载配置文件，创建Spring容器对象
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        // 从容器中取出对象
        User user = (User) context.getBean("user");
        // 执行方法
        user.say();
        // 关闭容器，单例对象销毁
        context.close();
    }

}
