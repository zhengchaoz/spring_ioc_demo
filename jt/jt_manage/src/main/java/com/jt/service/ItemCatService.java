package com.jt.service;

import com.jt.pojo.ItemCat;

import java.util.List;

/**
 * @author 郑超
 * @create 2021/5/19
 */
public interface ItemCatService {

    List<ItemCat> findItemCatList(Integer type);

    void updateStatus(ItemCat itemCat);

    void saveItemCat(ItemCat itemCat);

    void deleteItemCat(ItemCat itemCat);
}
