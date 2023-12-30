package com.kenshine.hasorweb.module;

import net.hasor.core.DimModule;
import net.hasor.web.WebApiBinder;
import net.hasor.web.WebModule;
import net.hasor.web.annotation.MappingTo;
import org.springframework.stereotype.Component;

import java.util.Set;

/**
 * hasorweb模块
 * @author Administrator
 */
@DimModule
@Component()
public class StartModule implements WebModule {
    @Override
    public void loadModule(WebApiBinder apiBinder) throws Throwable {
        //设置请求响应编码
        apiBinder.setEncodingCharacter("utf-8", "utf-8");
        // 扫描所有带有 @MappingTo 特征类
        Set<Class<?>> aClass = apiBinder.findClass(MappingTo.class);
        // 配置控制器
        apiBinder.loadMappingTo(aClass);
        System.out.println("Hasor web模块加载");
    }
}