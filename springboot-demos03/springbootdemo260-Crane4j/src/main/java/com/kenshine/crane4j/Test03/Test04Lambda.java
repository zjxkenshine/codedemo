package com.kenshine.crane4j.Test03;

import cn.crane4j.core.container.Container;
import cn.crane4j.core.container.Containers;
import cn.crane4j.core.support.Crane4jGlobalConfiguration;
import cn.crane4j.core.support.DataProvider;

import java.util.Collections;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author by kenshine
 * @Classname Test04Lambda
 * @Description Lambda容器
 * @Date 2023-10-16 13:24
 * @modified By：
 * @version: 1.0$
 */
public class Test04Lambda {
    public void test(){
        // 定义Lambda容器，接受key值，并返回按key分组的数据源对象
        Container<String> container = Containers.forLambda("namespace", keys -> keys.stream().collect(Collectors.toMap(Function.identity(), Function.identity()))
        );

        // 获取全局上下文并注册容器
        Crane4jGlobalConfiguration configuration = SpringUtils.getBean(Crane4jGlobalConfiguration.class);
        configuration.registerContainer(container);



        // 固定返回某个集合
        DataProvider<Integer, ?> provider1 = DataProvider.fixed(Collections.emptyMap());
        Containers.forLambda("namespace", provider1);

        // 总是返回空集合
        DataProvider<Integer, ?> provider2 = DataProvider.empty();
        Containers.forLambda("namespace", provider2);
    }
}
