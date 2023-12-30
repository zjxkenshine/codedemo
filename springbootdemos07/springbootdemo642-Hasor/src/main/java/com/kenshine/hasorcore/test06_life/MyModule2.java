package com.kenshine.hasorcore.test06_life;

import net.hasor.core.ApiBinder;
import net.hasor.core.Module;

/**
 * @author by kenshine
 * @Classname MyModule2
 * @Description 代码指定创建bean
 * @Date 2023-12-30 13:46
 * @modified By：
 * @version: 1.0$
 */
public class MyModule2 implements Module {
    @Override
    public void loadModule(ApiBinder apiBinder) throws Throwable {
        apiBinder.bindType(PojoBean3.class)
                // 初始化方法，相当于 @Init 注解
                .initMethod("init")
                // 单例，相当于 @Singleton 注解
                .asEagerSingleton();
    }
}
