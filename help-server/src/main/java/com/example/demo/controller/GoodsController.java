package com.example.demo.controller;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.common.Result;
import com.example.demo.common.ResultEnum;
import com.example.demo.common.ResultUtil;
import com.example.demo.entity.Goods;
import com.example.demo.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * @author LMH
 * @date 2022/4/26 1:00
 * @description 任务Controller层
 */

@RestController
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    GoodsService goodsService;

    /**
     * 保存任务
     */
    @PostMapping("/save")
    public Result<?> save(@RequestBody Goods goods){
        try {
            goods.setCreate_time(new Date());
            goodsService.save(goods);

            return ResultUtil.success();
        }catch (Exception e){
            return ResultUtil.error(ResultEnum.SAVE_FAILED.getCode(), ResultEnum.SAVE_FAILED.getMsg());
        }
    }

    /**
     * 分页获取任务列表
     */
    @GetMapping("/getGoods")
    public Result<?> getGoods(@RequestParam(defaultValue = "1") Integer pageNum,
                              @RequestParam(defaultValue = "15") Integer pageSize){
        try {
            Page<Goods> page = goodsService.page(new Page<Goods>(pageNum, pageSize));

            return ResultUtil.success(page);
        }catch (Exception e){
            return ResultUtil.error(ResultEnum.UNKNOWN_ERROR.getCode(), ResultEnum.USER_NOT_EXIST.getMsg());
        }
    }

    /**
     * 任务查找
     */
    @GetMapping("/searchGoods")
    public Result<?> searchGoods(@RequestParam(defaultValue = "1") Integer pageNum,
                                 @RequestParam(defaultValue = "15") Integer pageSize,
                                 @RequestParam(defaultValue = "") String search){
        LambdaQueryWrapper<Goods> wrapper = Wrappers.<Goods>lambdaQuery();
        if(StrUtil.isNotBlank(search)){
            wrapper.like(Goods::getName, search);
        }
        try {
            Page<Goods> page = goodsService.page(new Page<>(pageNum, pageSize), wrapper);

            return ResultUtil.success(page);
        }catch (Exception e){
            return ResultUtil.error(ResultEnum.UNKNOWN_ERROR.getCode(), ResultEnum.USER_NOT_EXIST.getMsg());
        }
    }

    /**
     * 更新任务信息
     */
    @PutMapping("/updateGoods")
    public Result<?> updateGoods(@RequestBody Goods goods){
        try {
            goodsService.updateById(goods);

            return ResultUtil.success();
        }catch (Exception e){
            return ResultUtil.error(ResultEnum.UPDATE_FAILED.getCode(), ResultEnum.UPDATE_FAILED.getMsg());
        }
    }
}
