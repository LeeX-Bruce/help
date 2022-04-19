package com.example.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.entity.SysUser;
import com.example.demo.mapper.SysUserMapper;
import com.example.demo.service.SysUserService;
import org.springframework.stereotype.Service;

/**
 * @author LMH
 * @date 2022/4/16 22:30
 * @description
 */

@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

}
