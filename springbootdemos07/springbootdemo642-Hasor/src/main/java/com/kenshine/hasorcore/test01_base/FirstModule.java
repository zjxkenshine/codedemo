package com.kenshine.hasorcore.test01_base;

import net.hasor.core.ApiBinder;
import net.hasor.core.Hasor;
import net.hasor.core.Module;

/**
 * 第一个模块
 * @author kenshine
 */
public class FirstModule implements Module {
    @Override
    public void loadModule(ApiBinder apiBinder) {
        System.out.println("加载FirstModule");
    }

    public static void main(String[] args) {
        Hasor.create().build(new FirstModule());
    }
}