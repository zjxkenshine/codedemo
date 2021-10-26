package com.kenshine.domain;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/26 15:23
 * @description：订单
 * @modified By：
 * @version: $
 */
@Data
public class Order {

    @NotNull(message = "订单id不能为空")
    private Long orderId;
    @NotEmpty(message = "订单号不能为空")
    private String orderNumber;
    @NotEmpty(message = "订单描述信息不能为空")
    private String orderDescription;
    @Valid
    private Account account;

}
