package com.jt.controller;

import com.jt.pojo.ItemCatParam;
import com.jt.service.ItemCatParamService;
import com.jt.vo.SysResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author 郑超
 * @create 2021/5/20
 */
@RestController
@CrossOrigin
@RequestMapping("/itemCatParam")
public class ItemCatParamController {

    @Autowired
    private ItemCatParamService itemCatParamService;

    @GetMapping("/findItemCatParamListByType")
    public SysResult findItemCatParamListByType(ItemCatParam itemCatParam) {
        List<ItemCatParam> itemCatParams = itemCatParamService.selectItemCatParamListByType(itemCatParam);
        return SysResult.success().setData(itemCatParams);
    }

    @PostMapping("/addItemCatParam")
    public SysResult addItemCatParam(@RequestBody ItemCatParam itemCatParam) {
        itemCatParamService.addItemCatParam(itemCatParam);
        return SysResult.success();
    }

    @PutMapping("/updateItemCatParam")
    public SysResult updateItemCatParam(@RequestBody ItemCatParam itemCatParam) {
        itemCatParamService.updateItemCatParam(itemCatParam);
        return SysResult.success();
    }

    @DeleteMapping("/deleteItemCatParamById")
    public SysResult deleteItemCatParamById(Integer id) {
        itemCatParamService.deleteItemCatParamById(id);
        return SysResult.success();
    }
}
