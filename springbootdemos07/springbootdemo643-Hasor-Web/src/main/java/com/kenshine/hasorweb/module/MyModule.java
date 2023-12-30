package com.kenshine.hasorweb.module;

import net.hasor.core.ApiBinder;
import net.hasor.core.DimModule;
import net.hasor.core.Module;
import org.springframework.stereotype.Component;

/**
 * 新建一个 Hasor 的 Module 并将其用 Spring 管理起来
 * @author kenshine
 */
@DimModule
@Component()
public class MyModule implements Module {
    @Override
    public void loadModule(ApiBinder apiBinder) throws Throwable {
        System.out.println("hasor测试模块加载");
    }
}