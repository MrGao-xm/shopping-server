package com.example.hellospringboot.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.hellospringboot.entity.UmsMenu;
import com.example.hellospringboot.entity.UmsMenuNode;

import java.util.List;
/**
 * 后台菜单管理Service
 *
 */

public interface UmsMenuService extends IService<UmsMenu> {
    /**
     * 树形结构返回所有菜单列表
     */
    List<UmsMenuNode> treeList();
}
