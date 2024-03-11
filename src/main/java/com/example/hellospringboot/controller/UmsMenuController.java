package com.example.hellospringboot.controller;

import com.example.hellospringboot.api.CommonResult;
import com.example.hellospringboot.entity.UmsMenuNode;
import com.example.hellospringboot.service.UmsMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UmsMenuController {
    //查询所有菜单
    @Autowired
    private UmsMenuService menuService;
    @GetMapping("/menu")
    public CommonResult<List<UmsMenuNode>> treeList() {
        List<UmsMenuNode> list = menuService.treeList();
        System.out.println(list);
        return CommonResult.success(list);

    }
}
