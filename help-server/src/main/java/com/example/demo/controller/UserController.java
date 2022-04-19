package com.example.demo.controller;

import com.example.demo.common.Result;
import com.example.demo.entity.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author LMH
 * @date 2022/4/15 1:47
 * @description 用户Controller层
 */

@RestController //只返回JSON数据
@RequestMapping("/user")    //设置路由
public class UserController {

//    @PostMapping("/login")    //定义一个post接口
//    public Result login(@RequestBody User user){   //把前台返回的JSON映射为Java实体
//
//    }
}
