package com.kenshine.ordered.demo02;

import org.springframework.core.PriorityOrdered;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/15 10:39
 * @description：
 * @modified By：
 * @version: $
 */
public class Order01 implements PriorityOrdered {
    @Override
    public int getOrder() {
        return 3;
    }
}
