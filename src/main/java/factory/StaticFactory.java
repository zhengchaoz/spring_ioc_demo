package factory;

import java.util.Calendar;

/**
 * @user 郑超
 * @date 2021/4/21
 */
public class StaticFactory {

    public static Calendar getCalendar() {
        System.out.println("我被调用啦！");
        return Calendar.getInstance();
    }

}
