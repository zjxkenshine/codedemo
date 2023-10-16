package com.kenshine.crane4j.Test07;

import cn.crane4j.annotation.ContainerCache;
import cn.crane4j.annotation.ContainerMethod;
import cn.crane4j.core.cache.CacheManager;
import cn.crane4j.core.container.CacheableContainer;
import cn.crane4j.core.container.Container;
import cn.crane4j.core.container.LambdaContainer;
import cn.crane4j.core.support.Crane4jGlobalConfiguration;
import com.kenshine.crane4j.Test03.SpringUtils;
import com.kenshine.crane4j.domain.Foo;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author by kenshine
 * @Classname Test03CacheContainer
 * @Description 将一个普通容器配置为缓存容器
 * @Date 2023-10-16 17:13
 * @modified By：
 * @version: 1.0$
 */
public class Test03CacheContainer {

    // 方式一：手动替换缓存容器
    public void test1(){
        Crane4jGlobalConfiguration configuration = SpringUtils.getBean(Crane4jGlobalConfiguration.class);
        CacheManager cacheManager = SpringUtils.getBean(CacheManager.class);


        // 1、创建一个原始容器
        Container<Object> original = LambdaContainer.forLambda("original", keys -> {
            return Collections.emptyMap();
        });
        // 将原始容器包装并替换为缓存容器 注册
        configuration.registerContainer("namespace", () -> {
            return new CacheableContainer<>(original , cacheManager, "cacheName");
        });
    }

    // 方式二：手动替换缓存容器
    // @CacheContainerMethod(resultType = Foo.class) 组合注解
    @ContainerCache // 声明该方法容器为可缓存容器
    @ContainerMethod(resultType = Foo.class)
    public List<Foo> oneToManyMethod(List<String> args) {
        return args.stream().map(key -> new Foo(key, key)).collect(Collectors.toList());
    }

}
