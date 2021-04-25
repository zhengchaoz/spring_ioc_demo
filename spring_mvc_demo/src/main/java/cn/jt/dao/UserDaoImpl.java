package cn.jt.dao;

import cn.jt.pojo.User;
import org.springframework.stereotype.Repository;

/**
 * @user 郑超
 * @date 2021/4/22
 */
// 和@Component等价，相当于<bean id="userDao" class="cn.jt.dao.UserDaoImpl"/>
@Repository
//@Repository(value = "userDao")
public class UserDaoImpl implements UserDao {

    @Override
    public void addUser(User user) {
        System.out.println(user.toString());
    }

}
