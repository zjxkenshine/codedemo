package com.kenshine.guice.test02;

import com.google.inject.AbstractModule;
import com.kenshine.guice.test02.dao.Dao;
import com.kenshine.guice.test02.dao.DaoImpl;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/16 16:38
 * @description：测试Module
 * @modified By：
 * @version: $
 */
public class TestModule extends AbstractModule{

    @Override
    protected void configure() {
        bind(Dao.class).to(DaoImpl.class);
        bind(TestInjection1.class);
    }

}
