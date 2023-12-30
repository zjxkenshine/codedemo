package com.kenshine.hasorcore.test06_life;

import net.hasor.core.ApiBinder;
import net.hasor.core.Module;

/**
 * @author by kenshine
 * @Classname MyModule3
 * @Description 销毁bean
 * @Date 2023-12-30 13:51
 * @modified By：
 * @version: 1.0$
 */
public class MyModule3 implements Module {
    @Override
    public void loadModule(ApiBinder apiBinder) throws Throwable {
        apiBinder.bindType(PojoBean4.class)
                // 销毁方法，相当于 @Destroy 注解
                .destroyMethod("destroy1")
                // 单例，相当于 @Singleton 注解
                .asEagerSingleton();
    }
}
