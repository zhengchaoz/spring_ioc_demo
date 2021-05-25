package com.jt.controller;

import com.jt.pojo.User;
import com.jt.service.UserService;
import com.jt.vo.PageResult;
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

    @GetMapping("/list")
    public SysResult queryPage(PageResult pageResult) {
        pageResult = userService.queryPage(pageResult);
        return SysResult.success().setData(pageResult);
    }

    @PutMapping("/status/{id}/{status}")
    public SysResult updateStatusById(User user) {
        userService.updateStatusById(user);
        return SysResult.success();
    }

    @PostMapping("/add")
    public SysResult addUser(@RequestBody User user) {
        userService.addUser(user);
        return SysResult.success();
    }

    @DeleteMapping("/del/{id}")
    public SysResult deleteUser(@PathVariable Integer id) {
        userService.deleteUser(id);
        return SysResult.success();
    }

    @PutMapping("/edit")
    public SysResult editUser(@RequestBody User user) {
        userService.editUser(user);
        return SysResult.success();
    }
}
