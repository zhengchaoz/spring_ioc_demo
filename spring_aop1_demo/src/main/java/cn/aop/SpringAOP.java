package cn.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @user 郑超
 * @date 2021/4/26
 */
@Component// 被Spring容器管理
@Aspect// 标识该类是切面，需要开启Spring相关功能才能使用
public class SpringAOP {

//    @Before("bean(deptServiceImpl)")// 通过bean的ID，扫描该类的所有方法
//    @Before("within(cn.service.impl.DeptServiceImpl)")// 通过包名，扫描该类的所有方法
//    @Before("within(cn.*.DeptServiceImpl)") // .*：匹配一级包下的任意类
//    @Before("within(cn..*.DeptServiceImpl)")// ..*：匹配多级包下的任意类
//    @Before("within(cn..*)")// 包下的任意类
//    @Before("execution(void cn..*.DeptServiceImpl.update*(..))")// update*：匹配以update开头的方法
//    @Before("execution(* cn..*.*(..))")// 匹配cn包下所有包所有类所有方法
//    @Before("execution(* cn..*.*(Integer))")

    @Pointcut("@annotation(cn.anno.Cache)")// 定义切入点表达式
    public void annotate() {
    }

    // 提取共性
    @Pointcut("bean(deptServiceImpl)")
    public void beanCut() {
    }

    @Before("beanCut()")// 在目标方法执行前执行
    @Order(1)// 值越低优先级越高
    public void before(JoinPoint joinPoint) {// JoinPoint连接点
        System.out.println("joinPoint.getTarget(): " + joinPoint.getTarget().getClass());
        System.out.println(joinPoint.getSignature().getDeclaringTypeName());
        System.out.println(joinPoint.getSignature().getName());
        System.out.println(Arrays.toString(joinPoint.getArgs()));
        System.out.println("@before通知...");
    }

    // returning：得到目标方法的返回值
    @AfterReturning(pointcut = "annotate()", returning = "result")// 在目标方法返回后执行
    public void afterReturning(Object result) {
        System.out.println("目标方法返回值：" + result);
        System.out.println("@AAfterReturning通知...");
    }

    // throwing：得到目标方法的异常信息
    @AfterThrowing(pointcut = "annotate()", throwing = "e")// 在目标方法报错后执行
    public void afterThrowing(Exception e) {
        System.out.println("@AfterThrowing通知...");
    }

    @After("annotate()")// 在目标方法执行后执行
    public void after() {
        System.out.println("@After通知...");
    }

    // 可以控制目标方法是否执行
    @Around("annotate()")
    public Object around(ProceedingJoinPoint pjp) {
        System.out.println("环绕通知开始...");
        Object o = null;
        try {
            o = pjp.proceed();// 执行下一个通知或目标方法
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println("环绕通知结束...");
        return o;
    }

}
