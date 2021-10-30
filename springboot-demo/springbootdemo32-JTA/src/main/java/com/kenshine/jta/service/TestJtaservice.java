package com.kenshine.jta.service;

import com.kenshine.jta.domain.User;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/30 10:28
 * @description：测试JTA事务
 * @modified By：
 * @version: $
 */
public interface TestJtaservice {
    void testInsertUser(User user);
    void testInsertUser2(User user);
}
