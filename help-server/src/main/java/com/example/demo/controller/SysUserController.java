package com.example.demo.controller;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.common.Result;
import com.example.demo.common.ResultEnum;
import com.example.demo.common.ResultUtil;
import com.example.demo.entity.SysUser;
import com.example.demo.service.SysUserService;
import com.example.demo.service.impl.SysUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Wrapper;
import java.util.Date;

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
    @PostMapping("/save")   //添加信息用Post
    public Result<?> save(@RequestBody SysUser sysUser){
        try {
            sysUser.setCreate_time(new Date());
            sysUserService.save(sysUser);

            return ResultUtil.success();
        }catch (Exception e){
            return ResultUtil.error(ResultEnum.SAVE_FAILED.getCode(), ResultEnum.SAVE_FAILED.getMsg());
        }
    }

    /**
     * 更新管理员信息
     */
    @PutMapping("/updateSysUser")   //更改信息用Put
    public Result<?> updateSysUser(@RequestBody SysUser sysUser){
        try {
            sysUserService.updateById(sysUser);

            return ResultUtil.success();
        }catch (Exception e){
            return ResultUtil.error(ResultEnum.UPDATE_FAILED.getCode(), ResultEnum.UPDATE_FAILED.getMsg());
        }
    }

    /**
     * 分页获取管理员列表
     */
    @GetMapping("/getSysUser")  //获取信息用Get
    public Result<?> searchSysUser(@RequestParam(defaultValue = "1") Integer pageNum,
                                   @RequestParam(defaultValue = "15") Integer pageSize,
                                   @RequestParam(defaultValue = "") String search){
        LambdaQueryWrapper<SysUser> wrapper = Wrappers.<SysUser>lambdaQuery();
        if(StrUtil.isNotBlank(search)){
            wrapper.like(SysUser::getUser_name, search);
        }
        try {
            Page<SysUser> page = sysUserService.page(new Page<>(pageNum, pageSize), wrapper);

            return ResultUtil.success(page);
        }catch (Exception e){
            return ResultUtil.error(ResultEnum.UNKNOWN_ERROR.getCode(), ResultEnum.USER_NOT_EXIST.getMsg());
        }
    }
}
