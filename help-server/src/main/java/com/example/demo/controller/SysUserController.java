package com.example.demo.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.common.Result;
import com.example.demo.common.ResultUtil;
import com.example.demo.entity.SysUser;
import com.example.demo.service.SysUserService;
import com.example.demo.service.impl.SysUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Wrapper;

/**
 * @author LMH
 * @date 2022/4/16 21:49
 * @description
 */

@RestController
@RequestMapping("/sys_user")
public class SysUserController {

    @Autowired
    SysUserService sysUserService;

//    /**
//     * 后台管理页面登录
//     */
//    @PostMapping("/login")
//    public Result<?> login(String username, String password){
//        SysUser sysUser = sysUserService
//    }

    /**
     * 保存管理员
     */
    @PostMapping("/save")
    public Result<?> save(@RequestBody SysUser sysUser){
        sysUserService.save(sysUser);

        return ResultUtil.success();
    }

    /**
     * 分页获取管理员列表
     */
    @GetMapping("/getSysUser")
    public Result<?> searchSysUser(@RequestParam(defaultValue = "1") Integer pageNum,
                                   @RequestParam(defaultValue = "15") Integer pageSize,
                                   @RequestParam(defaultValue = "") String search){
        Page<SysUser> page = sysUserService.page(new Page<>(pageNum, pageSize), Wrappers.<SysUser>lambdaQuery().like(SysUser::getUser_name, search));

        return ResultUtil.success(page);
    }
}
