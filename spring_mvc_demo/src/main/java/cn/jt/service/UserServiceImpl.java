package cn.jt.service;

import cn.jt.dao.UserDao;
import cn.jt.pojo.User;
import org.springframework.stereotype.Service;

/**
 * @user 郑超
 * @date 2021/4/22
 */
// 和@Component等价，相当于<bean id="userServiceImpl" class="cn.jt.service.UserServiceImpl"/>
@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }

}
