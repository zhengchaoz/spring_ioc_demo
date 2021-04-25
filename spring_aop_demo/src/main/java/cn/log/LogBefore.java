package cn.log;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * 侵入式AOP
 *
 * @user 郑超
 * @date 2021/4/25
 */
public class LogBefore implements MethodBeforeAdvice {

    /**
     * @param method  要执行目标对象的方法
     * @param objects 参数
     * @param o       目标对象
     * @throws Throwable
     */
    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println(o.getClass().getName() + "的" + method.getName() + "被执行了");
    }
}
