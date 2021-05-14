package com.jt.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jt.mapper.RightsMapper;
import com.jt.pojo.Rights;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 郑超
 * @create 2021/5/14
 */
@Service
public class RightsServiceImpl implements RightsService {

    @Autowired
    private RightsMapper rightsMapper;

    @Override
    public List<Rights> getRightsTree() {
        List<Rights> parent = rightsMapper.selectList(new QueryWrapper<Rights>().eq("parent_id", 0));
        for (Rights r : parent) {
            r.setChildren(rightsMapper.selectList(new QueryWrapper<Rights>().eq("parent_id", r.getId())));
        }
        return parent;
    }
}
