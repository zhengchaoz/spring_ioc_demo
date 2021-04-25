package factory;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Calendar;

/**
 * @user 郑超
 * @date 2021/4/21
 */
public class StaticFactoryTest {

    @Test
    public void testGetCalendar(){
        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        Calendar calendar = (Calendar) context.getBean("calendar");
        System.out.println(calendar);
    }

}
