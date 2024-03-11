package com.example.hellospringboot.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@TableName("ums_admin")
public class UmsAdmin {
    @TableId(value = "id")
    private long id;
    private String username;
    private String password;
    private String  icon;
    private String email;
    @TableField(value = "nick_name")
    private String nickName;
    private String note;
    @TableField(value = "create_time")
    private Date createTime;
    @TableField(value = "login_time")
    private Date loginTime;
    private Integer status;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", icon='" + icon + '\'' +
                ", email='" + email + '\'' +
                ", nickName='" + nickName + '\'' +
                ", note='" + note + '\'' +
                ", create_Time='" + createTime + '\'' +
                ", login_Time='" + loginTime + '\'' +
                ", status=" + status +
                '}';
    }
}



