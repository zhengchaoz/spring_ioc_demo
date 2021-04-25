package cn.utils;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 通用的动态代理工厂类
 *
 * @user 郑超
 * @date 2021/4/25
 */
public class JDKProxyFactory {

    /**
     * InvocationHandler.invoke()中定义了代理类的行为逻辑代码
     *
     * @param target 目标类（被代理类）
     * @param <E> 泛型
     * @return 动态生成的代理类的对象
     */
    public static <E> E getProxy(E target) {
        return (E) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(),
                (proxy, method, args) -> {
                    System.out.println("=事务开启==");
                    Object o = method.invoke(target, args);
                    System.out.println("=事务关闭==");
                    return o;
                });
    }

}
