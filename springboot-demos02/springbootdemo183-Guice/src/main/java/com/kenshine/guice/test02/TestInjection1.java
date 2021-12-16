package com.kenshine.guice.test02;

import com.google.inject.Inject;
import com.kenshine.guice.test02.dao.Dao;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/16 16:35
 * @description：属性注入
 * @modified By：
 * @version: $
 */
public class TestInjection1 {
    @Inject
    private Dao dao;

    void test(){

        dao.testGuice();
    }
}
