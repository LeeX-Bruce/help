package com.example.demo.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.example.demo.common.Result;
import com.example.demo.common.ResultEnum;
import com.example.demo.common.ResultUtil;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * @author LMH
 * @date 2022/4/15 1:47
 * @description 用户Controller层
 */

@RestController //只返回JSON数据
@RequestMapping("/user")    //设置路由
public class UserController {

    @Autowired
    UserService userService;

    /**
     * 保存用户
     */
    @PostMapping("/save")
    public Result save(@RequestBody User user){
        try {
            user.setCreate_time(new Date());
            userService.save(user);

            return ResultUtil.success();
        }catch (Exception e){
            return ResultUtil.error(ResultEnum.SAVE_FAILED.getCode(), ResultEnum.SAVE_FAILED.getMsg());
        }
    }

    /**
     * 用户登录
     */
    @GetMapping("/login")    //定义一个Get接口
    public Result login(@RequestBody User user){   //把前台返回的JSON映射为Java实体
        LambdaQueryWrapper<User> wrapper = Wrappers.lambdaQuery();

        wrapper.eq(User::getOpenid, user.getOpenid());
        User one = userService.getOne(wrapper);

        //用户不存在，保存
        if(one == null)
            save(user);

        return ResultUtil.success(user);
    }


}
