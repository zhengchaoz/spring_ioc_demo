package com.jt.controller;

import com.jt.pojo.Item;
import com.jt.service.ItemService;
import com.jt.vo.PageResult;
import com.jt.vo.SysResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author 郑超
 * @create 2021/5/20
 */
@Slf4j
@RestController
@CrossOrigin
@RequestMapping("/item")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping("/getItemList")
    public SysResult getItemList(PageResult pageResult) {
        PageResult items = itemService.getItemList(pageResult);
        log.info(items.toString());
        return SysResult.success().setData(items);
    }

    @PutMapping("/updateItemStatus")
    public SysResult updateItemStatus(@RequestBody Item item) {
        itemService.updateItemStatus(item);
        return SysResult.success();
    }

    @DeleteMapping("/deleteItemById")
    public SysResult deleteItemById(Integer id) {
        itemService.deleteItemById(id);
        return SysResult.success();
    }



}
