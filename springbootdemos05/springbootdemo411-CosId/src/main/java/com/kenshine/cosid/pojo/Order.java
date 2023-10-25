package com.kenshine.cosid.pojo;

import lombok.Data;
import me.ahoo.cosid.annotation.CosId;

/**
 * @author by kenshine
 * @Classname Order
 * @Description 测试cosid生成id
 * @Date 2023-10-25 9:39
 * @modified By：
 * @version: 1.0$
 */
@Data
public class Order {
    @CosId(value = "order")
    private Long orderId;
    private Long userId;

}
