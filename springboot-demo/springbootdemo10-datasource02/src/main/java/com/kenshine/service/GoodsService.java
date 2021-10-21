package com.kenshine.service;

import com.kenshine.entity.Goods;

import java.util.List;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/21 11:24
 * @description：商品接口
 * @modified By：
 * @version: $
 */
public interface GoodsService {
    List<Goods> findAll();
}
