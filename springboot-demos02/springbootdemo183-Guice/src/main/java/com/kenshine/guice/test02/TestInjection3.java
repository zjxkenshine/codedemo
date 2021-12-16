package com.kenshine.guice.test02;

import com.google.inject.Inject;
import com.kenshine.guice.test02.dao.Dao;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/16 16:40
 * @description：setter注入
 * @modified By：
 * @version: $
 */
public class TestInjection3 {

    private Dao dao;

    @Inject
    public void setDao(Dao dao) {
        this.dao = dao;
    }


    void test() {

        dao.testGuice();
    }
}
