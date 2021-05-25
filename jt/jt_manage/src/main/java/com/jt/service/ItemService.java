package com.jt.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.jt.pojo.Item;
import com.jt.vo.ItemVo;
import com.jt.vo.PageResult;

/**
 * @author 郑超
 * @create 2021/5/20
 */
public interface ItemService {

    PageResult getItemList(PageResult pageResult);

    void updateItemStatus(Item item);

    void deleteItemById(Integer id);

    public void saveItem(ItemVo itemVo) throws JsonProcessingException;
}
