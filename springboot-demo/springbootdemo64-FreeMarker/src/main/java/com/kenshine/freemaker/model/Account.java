package com.kenshine.freemaker.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/6 10:51
 * @description：数据模型类
 * @modified By：
 * @version: $
 */
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Account {
    private Long accountId;
    private String accountName;
    private String accountPassword;
    private User user;
    private List<Order> orders;
}
