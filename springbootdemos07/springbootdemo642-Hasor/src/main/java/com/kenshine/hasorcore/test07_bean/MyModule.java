package com.kenshine.hasorcore.test07_bean;

import net.hasor.core.ApiBinder;
import net.hasor.core.Module;

/**
 * 设置Bean ID
 * @author kenshine
 */
public class MyModule implements Module {
    @Override
    public void loadModule(ApiBinder apiBinder) throws Throwable {
        apiBinder.bindType(InfoBean.class).idWith("beanA");
        apiBinder.bindType(InfoBean.class).idWith("beanB");
    }
}