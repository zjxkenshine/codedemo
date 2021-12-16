package com.kenshine.guice.test02;

import com.google.inject.Inject;
import com.kenshine.guice.test02.dao.Dao;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/16 16:36
 * @description：构造器注入
 * @modified By：
 * @version: $
 */
public class TestInjection2 {
    private Dao dao;

    @Inject
    public TestInjection2(Dao dao) {
        this.dao = dao;
    }

    void test() {

        dao.testGuice();
    }
}
