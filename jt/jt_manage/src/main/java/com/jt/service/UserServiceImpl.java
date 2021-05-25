package com.jt.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jt.mapper.UserMapper;
import com.jt.pojo.User;
import com.jt.vo.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;

import java.time.LocalDate;
import java.util.Date;
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

    @Override
    public PageResult queryPage(PageResult pageResult) {
        Page<User> userPage = userMapper.selectPage(
                new Page<>(pageResult.getPageNum(), pageResult.getPageSize()),
                new QueryWrapper<User>().like(
                        StringUtils.hasLength(pageResult.getQuery()),
                        "username",
                        pageResult.getQuery()
                )
        );
        return pageResult.setTotal(userPage.getTotal()).setRows(userPage.getRecords());
    }

    @Override
    public void updateStatusById(User user) {
        userMapper.updateById(user);
    }

    @Override
    public void addUser(User user) {
        user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes())).setStatus(true);
        userMapper.insert(user);
    }

    @Override
    public void deleteUser(Integer id) {
        userMapper.deleteById(id);
    }

    @Override
    public void editUser(User user) {
        userMapper.updateById(user);
    }
}
