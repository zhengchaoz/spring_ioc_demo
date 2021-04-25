package factory;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Calendar;

/**
 * @user Administrator
 * @date 2021/4/21
 */
public class InstanceFactoryTest {

    @Test
    public void testGetCalendar(){
        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        Calendar calendar = (Calendar) context.getBean("factory");
        System.out.println(calendar);
    }

}
