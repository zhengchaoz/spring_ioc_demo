package cn.jt.controller;

import cn.jt.pojo.User;
import cn.jt.service.UserService;
import org.springframework.stereotype.Controller;

/**
 * @user 郑超
 * @date 2021/4/22
 */
// 和@Component等价，相当于<bean id="userController" class="cn.jt.controller.UserController"/>
@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService, User user) {
        this.userService = userService;
        this.user = user;
    }

    private final User user;

    public void addUser() {
        userService.addUser(user);
    }

}
