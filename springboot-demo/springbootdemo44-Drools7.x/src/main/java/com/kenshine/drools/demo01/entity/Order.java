package com.kenshine.drools.demo01.entity;

import lombok.Data;
import lombok.ToString;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/2 16:26
 * @description：订单
 * @modified By：
 * @version: $
 */
@Data
@ToString
public class Order {

    private Double originalPrice;//订单原始价格，即优惠前价格

    private Double realPrice;//订单真实价格，即优惠后价格

}
