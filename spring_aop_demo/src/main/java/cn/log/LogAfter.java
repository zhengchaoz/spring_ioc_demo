package cn.log;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

/**
 * @user 郑超
 * @date 2021/4/25
 */
public class LogAfter implements AfterReturningAdvice {

    /**
     * @param returnValue 返回值
     * @param method      要执行目标对象的方法
     * @param args        参数
     * @param target      目标对象
     * @throws Throwable
     */
    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        System.out.println("执行了" + method.getName() + "方法，返回结果为：" + returnValue);
    }
}
