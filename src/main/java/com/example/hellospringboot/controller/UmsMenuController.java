package com.example.hellospringboot.controller;

import com.example.hellospringboot.entity.UmsMenuNode;
import com.example.hellospringboot.entity.User;
import com.example.hellospringboot.mapper.UmsMenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UmsMenuController {
    //查询所有菜单
    @Autowired
    private UmsMenuMapper umsMenuNode;
    @GetMapping("/menu")
    public List query(){
        //查询所有菜单
    List<UmsMenuNode> list = umsMenuNode.selectList(null);
        return list;
    }
}
