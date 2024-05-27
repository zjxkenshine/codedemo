package com.kenshine.logrecord.model;

import cn.monitor4all.logRecord.annotation.LogRecordDiffObject;
import lombok.Data;

/**
 * @author by kenshine
 * @Classname Order
 * @Description 订单
 * @Date 2024-05-27 11:00
 * @modified By：
 * @version: 1.0$
 */
@LogRecordDiffObject(alias = "用户信息实体")
@Data
public class Order {
    private Long orderId;
    private String userName;
    private Long userId;
    private String newFollower;
}
