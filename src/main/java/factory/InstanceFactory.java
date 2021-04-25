package factory;

import java.util.Calendar;

/**
 * @user 郑超
 * @date 2021/4/21
 */
public class InstanceFactory {

    public Calendar getCalendar() {
        System.out.println("我被调用了，不是静态的！！");
        return Calendar.getInstance();
    }

}
