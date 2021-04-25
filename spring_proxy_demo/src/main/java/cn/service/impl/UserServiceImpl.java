package cn.service.impl;

import cn.dao.UserDao;
import cn.pojo.User;
import cn.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @user 郑超
 * @date 2021/4/25
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Override
    public void deleteUser(User user) {
        userDao.addUser(user);
    }
}
