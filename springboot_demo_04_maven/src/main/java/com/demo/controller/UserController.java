package com.demo.controller;

import com.demo.pojo.User;
import com.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 郑超
 * @create 2021/5/6
 */
@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ResponseBody
    @GetMapping("/")
    public String Hello() {
        return "hello!";
    }

    @GetMapping("/userList")
    public String userList(Model model) {
        List<User> users = userService.findAll();
        model.addAttribute("userList", users);
        return "userList";
    }

    @RequestMapping("/add/{name}/{age}/{sex}")
    public String addUser(@PathVariable Integer age, @PathVariable String name, @PathVariable String sex) {
        userService.addUser(age, name, sex);
        return "forward:/userList";
    }
}
