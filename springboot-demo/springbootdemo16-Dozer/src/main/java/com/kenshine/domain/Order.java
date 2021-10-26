package com.kenshine.domain;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/26 10:06
 * @description：订单
 * @modified By：
 * @version: $
 */
@Accessors(chain = true)
@Data
public class Order {
    private Long id;
    private String number;
    private String description;
    private User user;
}
