package com.kenshine.binder.domain;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/19 14:30
 * @description：订单表单
 * @modified By：
 * @version: 1.0$
 */
@Data
@ToString
public class OrderForm {

    private String id;

    private String userName;

    private Date addTime;
}
