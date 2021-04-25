package factory;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Calendar;

/**
 * @user 郑超
 * @date 2021/4/21
 */
public class SpringFactoryTest {

    @Test
    public void test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        Calendar calendar = (Calendar) context.getBean("calendar2");
        Calendar calendar2 = (Calendar) context.getBean("calendar2");
        System.out.println(calendar == calendar2);
    }

}
