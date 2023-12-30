package com.kenshine.hasorcore.test06_life;

import net.hasor.core.ApiBinder;
import net.hasor.core.Module;

/**
 * 初始化方式2 initMethod方法指定
 * @author kenshine
 */
public class MyModule implements Module {
    @Override
    public void loadModule(ApiBinder apiBinder) throws Throwable {
        apiBinder.bindType(PojoBean1.class).initMethod("init");
    }


}