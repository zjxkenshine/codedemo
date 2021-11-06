package com.kenshine.freemaker.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/6 10:52
 * @description：订单
 * @modified By：
 * @version: $
 */
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Order {
    private Long orderId;
    private String orderNumber;
    private String orderDescription;
    private Account account;
}
