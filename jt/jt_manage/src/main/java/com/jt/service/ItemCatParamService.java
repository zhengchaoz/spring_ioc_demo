package com.jt.service;

import com.jt.pojo.ItemCatParam;

import java.util.List;

/**
 * @author 郑超
 * @create 2021/5/20
 */
public interface ItemCatParamService {

    List<ItemCatParam> selectItemCatParamListByType(ItemCatParam itemCatParam);

    void addItemCatParam(ItemCatParam itemCatParam);

    void updateItemCatParam(ItemCatParam itemCatParam);

    void deleteItemCatParamById(Integer id);
}
