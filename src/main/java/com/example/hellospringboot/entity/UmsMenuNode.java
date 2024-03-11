package com.example.hellospringboot.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@TableName("ums_menu")
public class UmsMenuNode extends UmsMenu {
    @ApiModelProperty(value = "子级菜单")
    @TableField(exist=false)
    private List<UmsMenuNode> children;
}
