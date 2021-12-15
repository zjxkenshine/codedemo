package com.kenshine.ordered.demo02;

import org.springframework.core.PriorityOrdered;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/15 10:40
 * @description：
 * @modified By：
 * @version: $
 */
public class Order02 implements PriorityOrdered {
    @Override
    public int getOrder() {
        return 2;
    }
}
