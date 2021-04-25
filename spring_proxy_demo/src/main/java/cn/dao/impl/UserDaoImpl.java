package cn.dao.impl;

import cn.dao.UserDao;
import cn.pojo.User;
import org.springframework.stereotype.Repository;

/**
 * @user 郑超
 * @date 2021/4/25
 */
@Repository
public class UserDaoImpl implements UserDao {

    @Override
    public Integer addUser(User user) {
        System.out.println(user.toString());
        return null;
    }
}
