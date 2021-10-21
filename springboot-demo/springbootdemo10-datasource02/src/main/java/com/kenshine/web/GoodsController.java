package com.kenshine.web;

import com.kenshine.dao.dao01.GoodsRepository;
import com.kenshine.dao.dao02.UserRepository;
import com.kenshine.entity.Goods;
import com.kenshine.entity.User;
import com.kenshine.service.GoodsService;
import com.kenshine.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/21 10:34
 * @description: 商品接口
 * @modified By：
 * @version: $
 */
@RestController
public class GoodsController {


    @Autowired
    private UserService userService;

    @Autowired
    private GoodsService goodsService;

    @GetMapping(value = "/users")
    public List<User> users() {
        return userService.findAll();
    }

    @GetMapping(value = "/goods")
    public List<Goods> goods() {
        return goodsService.findAll();
    }


}
