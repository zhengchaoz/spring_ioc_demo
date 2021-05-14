package com.jt.controller;

import com.jt.service.RightsService;
import com.jt.vo.SysResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author 郑超
 * @create 2021/5/14
 */
@RestController
@CrossOrigin
@RequestMapping("/rights")
public class RightsController {

    @Autowired
    private RightsService rightsService;

    @GetMapping("/getRightsTree")
    public SysResult getRightsTree() {
        return SysResult.success().setData(rightsService.getRightsTree());
    }

}
