package cn.service.impl;

import cn.service.DeptService;
import org.springframework.stereotype.Service;

/**
 * @user 郑超
 * @date 2021/4/25
 */
@Service
public class DeptServiceImpl implements DeptService {

    @Override
    public void addDept() {
        System.out.println("调用方法！！");
    }
}
