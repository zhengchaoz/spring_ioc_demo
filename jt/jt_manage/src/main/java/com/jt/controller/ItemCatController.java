package com.jt.controller;

import com.jt.pojo.ItemCat;
import com.jt.service.ItemCatService;
import com.jt.vo.SysResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 郑超
 * @create 2021/5/19
 */
@RestController
@CrossOrigin
@RequestMapping("/itemCat")
public class ItemCatController {

    @Autowired
    private ItemCatService itemCatService;

    @GetMapping("/findItemCatList/{type}")
    public SysResult findItemCatList(@PathVariable Integer type) {
        List<ItemCat> itemCats = itemCatService.findItemCatList(type);
        return SysResult.success().setData(itemCats);
    }

    @PutMapping("/status/{id}/{status}")
    public SysResult status(ItemCat itemCat) {
        itemCatService.updateStatus(itemCat);
        return SysResult.success();
    }

    @PostMapping("/saveItemCat")
    public SysResult saveItemCat(@RequestBody ItemCat itemCat) {
        itemCatService.saveItemCat(itemCat);
        return SysResult.success();
    }

    @PutMapping("/updateItemCat")
    public SysResult updateItemCat(@RequestBody ItemCat itemCat) {
        itemCatService.updateStatus(itemCat);
        return SysResult.success();
    }

    @DeleteMapping("/deleteItemCat")
    public SysResult deleteItemCat(ItemCat itemCat) {
        itemCatService.deleteItemCat(itemCat);
        return SysResult.success();
    }

}
