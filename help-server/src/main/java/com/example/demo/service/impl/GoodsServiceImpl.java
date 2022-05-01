package com.example.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.entity.Goods;
import com.example.demo.mapper.GoodsMapper;
import com.example.demo.service.GoodsService;
import org.springframework.stereotype.Service;

/**
 * @author LMH
 * @date 2022/4/26 0:59
 * @description
 */

@Service
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods> implements GoodsService {
}
