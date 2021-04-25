package cn.service.impl;

import cn.pojo.User;
import cn.service.UserService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * @user 郑超
 * @date 2021/4/25
 */
@Service("staticProxy")
public class StaticProxy implements UserService {

    private final UserService target;

    public StaticProxy(@Qualifier("userService") UserService target) {
        this.target = target;
    }

    @Override
    public void addUser(User user) {
        System.out.println("===事务开启===");
        target.addUser(user);
        System.out.println("===事务关闭===");
    }

    @Override
    public void deleteUser(User user) {
        System.out.println("===事务开启===");
        target.deleteUser(user);
        System.out.println("===事务关闭===");
    }

}
