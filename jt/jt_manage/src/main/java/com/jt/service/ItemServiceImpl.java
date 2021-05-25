package com.jt.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jt.mapper.ItemDescMapper;
import com.jt.mapper.ItemMapper;
import com.jt.pojo.Item;
import com.jt.pojo.ItemParam;
import com.jt.vo.ItemVo;
import com.jt.vo.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

/**
 * @author 郑超
 * @create 2021/5/20
 */
@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemMapper itemMapper;

    @Autowired
    private ItemDescMapper itemDescMapper;

    @Override
    public PageResult getItemList(PageResult pageResult) {
        Page<Item> page = itemMapper.selectPage(new Page<>(pageResult.getPageNum(), pageResult.getPageSize()),
                new QueryWrapper<Item>().like(StringUtils.hasLength(pageResult.getQuery()), "title", pageResult.getQuery()));
        return pageResult.setRows(page.getRecords()).setTotal(page.getTotal());
    }

    @Override
    public void updateItemStatus(Item item) {
        itemMapper.updateById(item);
    }

    @Override
    public void deleteItemById(Integer id) {
        itemMapper.deleteById(id);
    }

    @Transactional
    @Override
    public void saveItem(ItemVo itemVo) throws JsonProcessingException {
        itemMapper.insert(itemVo.getItem().setStatus(true));
        itemDescMapper.insert(itemVo.getItemDesc().setId(itemVo.getItem().getId()));
        String staticArray = new ObjectMapper().writeValueAsString(itemVo.getItemParam().getStaticArray());
        String dynamicArray = new ObjectMapper().writeValueAsString(itemVo.getItemParam().getDynamicArray());

    }

}
