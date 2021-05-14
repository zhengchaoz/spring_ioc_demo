package com.demo.controller;

import com.demo.pojo.AxiosPojo;
import com.demo.pojo.User;
import com.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 郑超
 * @create 2021/5/10
 */
//服务器接收请求时拦截，不符合同源策略就返回请求，不会去修改服务器数据
@CrossOrigin// 允许当前类中所有的方法执行跨域请求操作，默认所有请求访问
//@CrossOrigin("www.baidu.com")// 指定的域名可以访问
@RestController
public class AxiosController {

    @Autowired
    private UserService userService;

    @GetMapping("/axios/{name}")
    public String axiosGet(@PathVariable String name) {
        return "Get " + name;
    }

    @PostMapping("/axios/{name}")
    public String axiosPost(@PathVariable String name) {
        return "Post " + name;
    }

    @PostMapping("/axiosObj")
    public String axiosObjPost(@RequestBody AxiosPojo axiosPojo) {
        return "Post Obj: " + axiosPojo;
    }

    @PostMapping("/axiosForm")
    public String axiosFormPost(AxiosPojo axiosPojo) {
        return "Post Obj: " + axiosPojo;
    }

    @PutMapping("/axios/{name}")
    public String axiosPut(@PathVariable String name) {
        return "Put " + name;
    }

    @DeleteMapping("/axios/{name}")
    public String axiosDelete(@PathVariable String name) {
        return "Delete " + name;
    }

    @GetMapping("/user")
    public List<User> getAllUsers() {
        return userService.findAll();
    }

    @PutMapping("/user")
    public String editUser(@RequestBody User user) {
        System.out.println(user);
        return "更新成功！";
    }

    @DeleteMapping("/user")
    public String removeUser(Integer id) {
        System.out.println(id);
        return "删除成功！";
    }

}
