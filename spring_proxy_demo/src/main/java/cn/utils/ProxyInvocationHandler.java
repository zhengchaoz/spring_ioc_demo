package cn.utils;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 自动生成代理类
 *
 * @user 郑超
 * @date 2021/4/25
 */
public class ProxyInvocationHandler implements InvocationHandler {

    // 目标类
    private Object target;

    public void setTarget(Object target) {
        this.target = target;
    }

    // 生成代理类对象
    public Object getProxy() {
        return Proxy.newProxyInstance(this.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }

    // 处理代理类对象的方法，并返回结果
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(proxy, args);
    }

}
