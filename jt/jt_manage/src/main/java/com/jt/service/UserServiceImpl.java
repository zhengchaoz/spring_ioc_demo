package com.jt.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jt.mapper.UserMapper;
import com.jt.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.DigestUtils;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

/**
 * @author 刘昱江
 * 时间 2021/5/11
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> findAll() {
        return userMapper.selectList(null);
    }

    @Override
    public String findUser(User user) {
//        String md5 = DigestUtils.md5DigestAsHex(user.getPassword().getBytes());
//        User userDB = userMapper.selectOne(new QueryWrapper<User>()
//                .eq("username", user.getUsername())
//                .eq("password", md5));
        user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
        User userDB = userMapper.selectOne(new QueryWrapper<>(user));
        if (userDB == null)
            return null;
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
}
