package com.jt.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jt.mapper.ItemCatParamMapper;
import com.jt.pojo.ItemCatParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author 郑超
 * @create 2021/5/20
 */
@Service
public class ItemCatParamServiceImpl implements ItemCatParamService {

    @Autowired
    private ItemCatParamMapper itemCatParamMapper;

    @Override
    public List<ItemCatParam> selectItemCatParamListByType(ItemCatParam itemCatParam) {
        return itemCatParamMapper.selectList(new QueryWrapper<>(itemCatParam));
    }

    @Override
    @Transactional
    public void addItemCatParam(ItemCatParam itemCatParam) {
        itemCatParamMapper.insert(itemCatParam);
    }

    @Override
    public void updateItemCatParam(ItemCatParam itemCatParam) {
        itemCatParamMapper.updateById(itemCatParam);
    }

    @Override
    public void deleteItemCatParamById(Integer id) {
        itemCatParamMapper.deleteById(id);
    }
}
