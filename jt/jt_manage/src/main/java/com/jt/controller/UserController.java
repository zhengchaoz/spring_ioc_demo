package com.jt.controller;

import com.jt.pojo.User;
import com.jt.service.UserService;
import com.jt.vo.SysResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * @author 刘昱江
 * 时间 2021/5/11
 */
@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/hello")
    public List<User> hello(){
        return userService.findAll();
    }

    @PostMapping("/login")
    public SysResult login(@RequestBody User user) {
        String token = userService.findUser(user);
        if (StringUtils.hasLength(token))
            return SysResult.success(token);
        return SysResult.fail();
    }
}
