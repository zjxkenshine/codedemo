package com.kenshine.service.impl;

import com.kenshine.dao.dao01.GoodsRepository;
import com.kenshine.entity.Goods;
import com.kenshine.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/21 11:25
 * @description：商品业务接口实现
 * @modified By：
 * @version: $
 */
@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsRepository goodsRepository;

    @Override
    public List<Goods> findAll() {
        return goodsRepository.findAll();
    }

}
