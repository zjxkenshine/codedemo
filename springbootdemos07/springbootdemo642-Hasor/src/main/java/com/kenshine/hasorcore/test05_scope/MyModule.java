package com.kenshine.hasorcore.test05_scope;

import com.kenshine.hasorcore.test04_property.PojoBean;
import net.hasor.core.ApiBinder;
import net.hasor.core.AppContext;
import net.hasor.core.Hasor;
import net.hasor.core.Module;

/**
 * 单例bean使用
 * @author kenshine
 */
public class MyModule implements Module {
    @Override
    public void loadModule(ApiBinder apiBinder) {
        apiBinder.bindType(AopBean.class).asEagerSingleton();
    }

    public static void main(String[] args) {
        AppContext appContext = Hasor.create().build(new MyModule());
        AopBean pojoBean1 = appContext.getInstance(AopBean.class);
        AopBean pojoBean2 = appContext.getInstance(AopBean.class);
        System.out.println(pojoBean1 == pojoBean2);
    }
}