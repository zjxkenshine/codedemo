package com.kenshine.crane4j.Test07;

import cn.crane4j.core.cache.CacheManager;
import cn.crane4j.core.container.CacheableContainer;
import cn.crane4j.core.container.Container;
import cn.crane4j.core.container.LambdaContainer;
import com.kenshine.crane4j.Test03.SpringUtils;

import java.util.Collections;

/**
 * @author by kenshine
 * @Classname Test02CacheableContainer
 * @Description 缓存整合数据源容器 CacheableContainer
 * @Date 2023-10-16 17:11
 * @modified By：
 * @version: 1.0$
 */
public class Test02CacheableContainer {

    public void test(){
        // 1、创建一个原始容器
        Container<String> original = LambdaContainer.forLambda("original", keys -> {
            return Collections.emptyMap();
        });
        ///2、获取缓存管理器
        CacheManager cacheManager = SpringUtils.getBean(CacheManager.class);
        // 3、基于原始容器与缓存对象，构建带有缓存功能的容器
        CacheableContainer<String> container = new CacheableContainer<>(original, cacheManager, "cacheName");
    }

}
