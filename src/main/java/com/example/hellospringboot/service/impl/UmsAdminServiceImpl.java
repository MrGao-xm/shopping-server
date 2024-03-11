package com.example.hellospringboot.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.hellospringboot.entity.UmsAdmin;
import com.example.hellospringboot.entity.UmsMenuNode;
import com.example.hellospringboot.mapper.Usermapper;
import com.example.hellospringboot.service.UmsAdminService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UmsAdminServiceImpl extends ServiceImpl<Usermapper,UmsAdmin> implements UmsAdminService {
    @Autowired
    Usermapper  usermapper;
    @Override
    public Page<UmsAdmin> list(String keyword, Integer pageSize, Integer pageNum) {
        Page<UmsAdmin> page = new Page<>(pageNum, pageSize);
        LambdaQueryWrapper<UmsAdmin> lqw = new LambdaQueryWrapper<>();
        lqw.like(UmsAdmin::getUsername, keyword).or().like(UmsAdmin::getNickName, keyword);
        return this.page(page,lqw);
//        List<UmsAdmin> list = usermapper.selectPage(page, lqw).getRecords();

    }
    @Override
    public UmsAdmin register(UmsAdmin umsAdminParam) {
        UmsAdmin umsAdmin = new UmsAdmin();
        BeanUtils.copyProperties(umsAdminParam, umsAdmin);
        umsAdmin.setCreateTime(new Date());
        umsAdmin.setStatus(1);
        //查询是否有相同用户名的用户
        LambdaQueryWrapper<UmsAdmin> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(UmsAdmin::getUsername, umsAdmin.getUsername());
        List<UmsAdmin> umsAdminList = usermapper.selectList(queryWrapper);
        if (umsAdminList.size() > 0) {
            return null;
        }
        //将密码进行加密操作
//        String encodePassword = passwordEncoder.encode(umsAdmin.getPassword());
//        umsAdmin.setPassword(encodePassword);
//        adminMapper.insert(umsAdmin);
        usermapper.insert(umsAdmin);
        return umsAdmin;
    }
    @Override
    public int delete(Long id){
        return usermapper.deleteById(id);
    }
    @Override
    public int update(Long id, UmsAdmin admin){
        return usermapper.updateById(admin);
    }
}
