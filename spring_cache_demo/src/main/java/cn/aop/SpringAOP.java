package cn.aop;

import cn.pojo.User;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @user 郑超
 * @date 2021/4/27
 */
@Component
@Aspect
public class SpringAOP {

    private static final Map<Integer, User> map = new HashMap<>();

    @Around("execution(* cn..*.*(..))")
    public Object Around(ProceedingJoinPoint pjp) throws Throwable {
        Object proceed;
        User user = (User) pjp.getArgs()[0];
        if (map.containsKey(user.getId())) {
            return map.get(user.getId());
        } else {
            proceed = pjp.proceed();
            map.put(user.getId(), user);
        }
        return proceed;
    }

}
