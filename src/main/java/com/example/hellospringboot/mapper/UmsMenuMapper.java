package com.example.hellospringboot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.hellospringboot.entity.UmsMenuNode;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UmsMenuMapper extends BaseMapper<UmsMenuNode> {
}
