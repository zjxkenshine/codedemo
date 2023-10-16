package com.kenshine.crane4j.Test03;

import cn.crane4j.annotation.ContainerCache;
import cn.crane4j.annotation.ContainerMethod;
import cn.crane4j.core.support.Crane4jGlobalConfiguration;
import cn.crane4j.core.support.SimpleAnnotationFinder;
import cn.crane4j.core.support.SimpleCrane4jGlobalConfiguration;
import cn.crane4j.core.support.container.ContainerMethodAnnotationProcessor;
import cn.crane4j.core.support.container.DefaultMethodContainerFactory;
import cn.crane4j.core.support.container.MethodContainerFactory;
import cn.crane4j.core.support.container.MethodInvokerContainerCreator;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * @author by kenshine
 * @Classname Test06Method02
 * @Description 结果缓存
 * @Date 2023-10-16 13:49
 * @modified By：
 * @version: 1.0$
 */
public class Test05Method02 {
    @ContainerCache
    @ContainerMethod(
            namespace = "onoToOneMethod",
            resultType = Foo.class, resultKey = "id" // 返回的数据源对象类型为 Foo，并且需要按 id 分组
    )
    public Set<Foo> onoToOneMethod(List<String> args) {
        // do something
        return null;
    }


    // 手动构建 MethodContainerAnnotationProcessor
    public void test(){
        // 创建一个全局配置
        Crane4jGlobalConfiguration configuration = SimpleCrane4jGlobalConfiguration.create();
        // 构建方法容器处理器
        Collection<MethodContainerFactory> factories = Arrays.asList(new DefaultMethodContainerFactory(
                new MethodInvokerContainerCreator(null,null), SimpleAnnotationFinder.INSTANCE
        ));
        ContainerMethodAnnotationProcessor processor = new ContainerMethodAnnotationProcessor(factories,new SimpleAnnotationFinder());
    }
}
