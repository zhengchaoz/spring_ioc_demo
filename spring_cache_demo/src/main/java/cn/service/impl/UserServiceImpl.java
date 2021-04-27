package cn.service.impl;

import cn.pojo.User;
import cn.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @user 郑超
 * @date 2021/4/27
 */
@Service
public class UserServiceImpl implements UserService {

    @Override
    public void findUserById(User user) {
        System.out.println(user);
    }
}
