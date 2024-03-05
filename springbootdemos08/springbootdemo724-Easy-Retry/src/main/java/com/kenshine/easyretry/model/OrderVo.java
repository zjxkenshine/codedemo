package com.kenshine.easyretry.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class OrderVo {
    private String orderId; // 订单ID,用于唯一标识订单的编号
    private Integer source; // 订单来源信息,1-手机端下单 2-PC端下单
}