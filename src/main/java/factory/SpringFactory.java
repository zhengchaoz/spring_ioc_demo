package factory;

import org.springframework.beans.factory.FactoryBean;

import java.util.Calendar;

/**
 * Spring工厂模式
 *
 * @user 郑超
 * @date 2021/4/21
 */
public class SpringFactory implements FactoryBean<Calendar> {

    /**
     * 工厂模式实例化对象的方法
     *
     * @return
     */
    @Override
    public Calendar getObject() {
        System.out.println("我被调用了，是Spring工厂啦！！");
        return Calendar.getInstance();
    }

    /**
     * 获取对象类型
     *
     * @return
     */
    @Override
    public Class<?> getObjectType() {
        return Calendar.class;
    }

    /**
     * 是否是单例对象
     *
     * @return true: 是单例
     *         false: 是多例
     */
    @Override
    public boolean isSingleton() {
        return false;
    }

}
