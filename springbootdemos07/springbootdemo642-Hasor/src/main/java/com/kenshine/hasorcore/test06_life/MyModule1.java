package com.kenshine.hasorcore.test06_life;

import net.hasor.core.ApiBinder;
import net.hasor.core.Module;

/**
 * 启动创建bean
 * @author kenshine
 */
public class MyModule1 implements Module {
    @Override
    public void loadModule(ApiBinder apiBinder) throws Throwable {
        apiBinder.bindType(PojoBean.class);
    }
    
}