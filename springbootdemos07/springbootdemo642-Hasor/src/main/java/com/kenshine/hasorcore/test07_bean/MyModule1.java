package com.kenshine.hasorcore.test07_bean;

import net.hasor.core.ApiBinder;
import net.hasor.core.Module;

/**
 * @author by kenshine
 * @Classname MyModule1
 * @Description InfoBean 不同名
 * @Date 2023-12-30 14:08
 * @modified By：
 * @version: 1.0$
 */
public class MyModule1 implements Module {
    @Override
    public void loadModule(ApiBinder apiBinder) throws Throwable {
        apiBinder.bindType(InfoBean.class).nameWith("user");
        apiBinder.bindType(InfoBean.class).nameWith("data");
    }
}
