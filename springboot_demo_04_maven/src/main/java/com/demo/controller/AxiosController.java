package com.demo.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 郑超
 * @create 2021/5/10
 */
@CrossOrigin// 允许当前类中所有的方法执行跨域请求操作
@RestController
public class AxiosController {

    @GetMapping("/axios/{name}")
    public String axiosGet(@PathVariable String name) {
        return "Get " + name;
    }

}
