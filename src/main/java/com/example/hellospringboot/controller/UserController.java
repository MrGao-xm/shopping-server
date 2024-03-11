package com.example.hellospringboot.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.hellospringboot.api.CommonResult;
import com.example.hellospringboot.entity.UmsAdmin;
import com.example.hellospringboot.mapper.Usermapper;
import com.example.hellospringboot.service.UmsAdminService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
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
    @Autowired
    private UmsAdminService adminService;

    @ApiOperation("根据用户名或姓名分页获取用户列表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<IPage<UmsAdmin>> list(@RequestParam(value = "keyword", required = false) String keyword,
                                              @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                              @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize
                                              ) {
        Page<UmsAdmin> adminList = adminService.list(keyword, pageSize, pageNum);
        return CommonResult.success(adminList);
    }

    @ApiOperation("修改帐号状态")
    @RequestMapping(value = "/updateStatus/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult updateStatus(@PathVariable Long id,@RequestParam(value = "status") Integer status) {
        UmsAdmin umsAdmin = new UmsAdmin();
        umsAdmin.setStatus(status);
        LambdaUpdateWrapper<UmsAdmin> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.eq(UmsAdmin::getId, id).set(UmsAdmin::getStatus, status);
        boolean count=adminService.update(updateWrapper);
        if (count) {
            return CommonResult.success(true);
        }
        return CommonResult.failed();
    }
    @ApiOperation(value = "用户注册")
    @RequestMapping(value = "admin/register", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<UmsAdmin> register(@Validated @RequestBody UmsAdmin umsAdminParam) {
        UmsAdmin umsAdmin = adminService.register(umsAdminParam);
        if (umsAdmin == null) {
            return CommonResult.failed();
        }
        return CommonResult.success(umsAdmin);
    }

    @ApiOperation("删除指定用户信息")
    @RequestMapping(value = "admin/delete/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult delete(@PathVariable Long id) {
        int count = adminService.delete(id);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation("修改指定用户信息")
    @RequestMapping(value = "admin/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult update(@PathVariable Long id, @RequestBody UmsAdmin admin) {
        int count = adminService.update(id, admin);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }
    @PostMapping("/login")
    public String login(UmsAdmin user) {
        QueryWrapper<UmsAdmin> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username",user.getUsername()).eq("password",user.getPassword());
        UmsAdmin user1 = usermapper.selectOne(queryWrapper);
        if (user1!=null){
            return "登录失败";
        }else {
            return "登录成功";
        }
    }
}
