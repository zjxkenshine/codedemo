package com.kenshine.fel;

import cn.hutool.core.util.IdUtil;
import lombok.Data;

@Data
public class Goods {
    private Long id;

    private String name;

    private Integer stock;

    private String des;

    private String data;

    public static Goods randomGoods() {
        Goods goods = new Goods();
        goods.setId(IdUtil.getSnowflakeNextId());
        return goods;
    }
}