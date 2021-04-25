package cn;

import cn.config.SpringConfig;
import cn.pojo.User;
import cn.service.UserService;
import cn.service.impl.UserServiceImpl;
import cn.utils.JDKProxyFactory;
import cn.utils.ProxyInvocationHandler;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @user 郑超
 * @date 2021/4/25
 */
public class UserTest {

    @Test
    public void testStatic(){
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        // 传入接口类型，Spring会自动查找注入该接口的实现类，前提是只有一个实现类
        UserService userService = context.getBean("staticProxy", UserService.class);
        userService.addUser(new User(1, "郑超"));
    }

    @Test
    public void testDynamicProxy(){
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        UserService userService = context.getBean("userService", UserService.class);
        UserService userServiceProxy = JDKProxyFactory.getProxy(userService);
        userServiceProxy.addUser(new User(1, "郑超"));
    }

    @Test
    public void testDynamicProxy2(){
        UserService userService = new UserServiceImpl(null);
        ProxyInvocationHandler handler = new ProxyInvocationHandler();
        handler.setTarget(userService);
        UserService proxy = (UserService) handler.getProxy();
        proxy.addUser(null);
    }

}
