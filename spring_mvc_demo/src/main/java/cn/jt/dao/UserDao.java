package cn.jt.dao;

import cn.jt.pojo.User;
import org.springframework.stereotype.Repository;

/**
 * @user 郑超
 * @date 2021/4/22
 */
public interface UserDao {

    void addUser(User user);

}
