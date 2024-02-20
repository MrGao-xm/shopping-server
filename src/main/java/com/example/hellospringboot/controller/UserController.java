package com.example.hellospringboot.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.hellospringboot.entity.User;
import com.example.hellospringboot.mapper.Usermapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class  UserController {
    @GetMapping( "/hello")
    public String hello() {
        return "你好";
    }

    @Autowired
    private Usermapper usermapper;

    @GetMapping( "/user")
    public List query() {
        List<User> list = usermapper.selectList(null);
        System.out.println(list);
        return list;
    }
    @PostMapping("/user")
    public String save(User user) {
        int i = usermapper.insert(user);
        if (i>0){
            return "插入成功";
        }else {
            return "插入失败";
        }
    }
    @PutMapping("/user")
    public String update(User user) {
        if (usermapper.updateById(user)>0){
            return "更新成功";
        }else {
            return "更新失败";
        }
    }
    @DeleteMapping("/user/{id}")
    public String delete(@PathVariable("id") long id) {
        if (usermapper.deleteById(id)>0){
            return "删除成功";
        }else {
            return "删除失败";
        }
    }
    @PostMapping("/login")
    public String login(User user) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username",user.getUsername()).eq("password",user.getPassword());
        User user1 = usermapper.selectOne(queryWrapper);
        if (user1!=null){
            return "登录失败";
        }else {
            return "登录成功";
        }
    }
}
