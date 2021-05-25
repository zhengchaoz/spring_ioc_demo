package com.jt.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jt.mapper.ItemCatMapper;
import com.jt.pojo.ItemCat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author 郑超
 * @create 2021/5/19
 */
@Service
public class ItemCatServiceImpl implements ItemCatService {

    @Autowired
    private ItemCatMapper itemCatMapper;

    @Override
    public List<ItemCat> findItemCatList(Integer type) {
        List<ItemCat> itemCats = itemCatMapper.selectList(null);
        return itemCats.stream().filter(itemCat -> itemCat.getParentId() == 0)
                .peek(itemCat -> {
                    if (type != 1) {
                        List<ItemCat> children = getChildren(itemCat, itemCats, type);
                        if (!CollectionUtils.isEmpty(children)) itemCat.setChildren(children);
                    }
                })
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void updateStatus(ItemCat itemCat) {
        itemCatMapper.updateById(itemCat);
    }

    @Override
    @Transactional
    public void saveItemCat(ItemCat itemCat) {
        itemCatMapper.insert(itemCat.setStatus(true));
    }

    @Override
    public void deleteItemCat(ItemCat itemCat) {
        if (itemCat.getLevel() == 3)
            itemCatMapper.deleteById(itemCat.getId());
        if (itemCat.getLevel() == 2)
            itemCatMapper.delete(new QueryWrapper<ItemCat>().eq("parent_id", itemCat.getId())
                    .or().eq("id", itemCat.getId()));

    }

    private List<ItemCat> getChildren(ItemCat itemCat, List<ItemCat> itemCats, Integer type) {
        return itemCats.stream().filter(e -> Objects.equals(e.getParentId(), itemCat.getId()))
                .peek(e -> {
                    if (type != 2) {
                        List<ItemCat> children = getChildren(e, itemCats, type);
                        if (!CollectionUtils.isEmpty(children)) e.setChildren(children);
                    }
                })
                .collect(Collectors.toList());
    }

}
