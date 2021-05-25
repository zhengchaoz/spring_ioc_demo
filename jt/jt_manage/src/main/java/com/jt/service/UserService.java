package com.jt.service;

import com.jt.pojo.User;
import com.jt.vo.PageResult;

import java.util.List;

/**
 * @author 刘昱江
 * 时间 2021/5/11
 */
public interface UserService {

    List<User> findAll();

    String findUser(User user);

    PageResult queryPage(PageResult pageResult);

    void updateStatusById(User user);

    void addUser(User user);

    void deleteUser(Integer id);

    void editUser(User user);
}
