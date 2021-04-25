package cn.diy;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * @user 郑超
 * @date 2021/4/25
 */
@Aspect// 标注该类是一个切面
public class AnnotationPointCut {

    // 方法之前切入
    @Before("execution(* cn.service.impl.UserServiceImpl.*(..))")
    public void before() {
        System.out.println("===方法执行前=1==");
    }

    // 方法之后切入
    @After("execution(* cn.service.impl.UserServiceImpl.*(..))")
    public void after() {
        System.out.println("===方法执行后=1==");
    }

    // 在增强环绕中，可以给定一个参数，代表要获取的处理切入的点
    @Around("execution(* cn.service.impl.UserServiceImpl.*(..))")
    public void around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("方法执行前");
        System.out.println(pjp.getSignature());
        Object proceed = pjp.proceed();
        System.out.println(proceed);
        System.out.println("方法执行后");
    }

}
