package com.kenshine.hasorcore.test05_scope;

import net.hasor.core.ApiBinder;
import net.hasor.core.AppContext;
import net.hasor.core.Hasor;
import net.hasor.core.Module;

/**
 * @author by kenshine
 * @Classname MyModule1
 * @Description 原型模式 默认模式
 * @Date 2023-12-30 13:14
 * @modified By：
 * @version: 1.0$
 */
public class MyModule1 implements Module {
    @Override
    public void loadModule(ApiBinder apiBinder) {
        apiBinder.bindType(AopBean2.class).asEagerPrototype();
    }

    public static void main(String[] args) {
        AppContext appContext = Hasor.create().build(new MyModule1());
        AopBean pojoBean1 = appContext.getInstance(AopBean.class);
        AopBean pojoBean2 = appContext.getInstance(AopBean.class);
        System.out.println(pojoBean1 == pojoBean2);
    }
}
