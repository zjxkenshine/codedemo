package com.kenshine.hasorcore.test01_base;

import net.hasor.core.ApiBinder;
import net.hasor.core.Hasor;
import net.hasor.core.Module;

/**
 * @author by kenshine
 * @Classname SecondModule
 * @Description 第二个模块
 * @Date 2023-12-30 9:47
 * @modified By：
 * @version: 1.0$
 */
public class SecondModule implements Module {

    @Override
    public void loadModule(ApiBinder apiBinder) {
        System.out.println("加载第二个模块");
    }

    public static void main(String[] args) {
        // 多模块加载
        Hasor.create().build(new FirstModule(),new SecondModule());
    }
}
