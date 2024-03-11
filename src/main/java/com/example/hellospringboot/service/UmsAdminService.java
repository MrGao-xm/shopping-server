package com.example.hellospringboot.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.hellospringboot.entity.UmsAdmin;

import java.util.List;

public interface UmsAdminService extends IService<UmsAdmin> {
    /**
     * 根据用户名或昵称分页查询用户
     */
    Page<UmsAdmin> list(String keyword, Integer pageSize, Integer pageNum);
    UmsAdmin register(UmsAdmin umsAdmin);
    int delete(Long id);
    /**
     * 修改指定用户信息
     */
    int update(Long id, UmsAdmin admin);


}
