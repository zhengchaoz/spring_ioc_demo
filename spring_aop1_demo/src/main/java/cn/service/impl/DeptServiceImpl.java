package cn.service.impl;

import cn.anno.Cache;
import cn.service.DeptService;
import org.springframework.stereotype.Service;

/**
 * @user 郑超
 * @date 2021/4/26
 */
@Service
public class DeptServiceImpl implements DeptService {

    @Override
    public void addDept() {
        System.out.println("addDept()执行中...");
    }

    @Override
    public void updateDept() {
        System.out.println("updateDept()执行中...");
    }

    @Cache
    @Override
    public int deleteDept(int id) {
        System.out.println("deleteDept(" + id + ")执行中...");
        return id;
    }
}
