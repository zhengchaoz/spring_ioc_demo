package com.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.demo.pojo.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 郑超
 * @create 2021/5/6
 */
public interface UserService /*extends IService<User>*/ {
    List<User> findAll();

    void addUser(Integer age, String name, String sex);
}
