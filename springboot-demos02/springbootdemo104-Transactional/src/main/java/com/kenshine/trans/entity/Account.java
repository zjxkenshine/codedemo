package com.kenshine.trans.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.math.BigDecimal;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/21 21:40
 * @description：
 * @modified By：
 * @version: $
 */
@Data
@ToString
@EqualsAndHashCode
public class Account {
    private String accountId;
    private String accountName;
    private BigDecimal balance;
}
