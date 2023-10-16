package com.kenshine.crane4j.Test01;

import cn.crane4j.core.parser.handler.strategy.PropertyMappingStrategy;
import cn.crane4j.core.support.SimpleCrane4jGlobalConfiguration;

/**
 * @author by kenshine
 * @Classname config
 * @Description 自定义策略
 * @Date 2023-10-16 11:35
 * @modified By：
 * @version: 1.0$
 */
public class config {

    public void test(){
        SimpleCrane4jGlobalConfiguration configuration = SimpleCrane4jGlobalConfiguration.create();
        PropertyMappingStrategy customStrategy =new CustomPropertyMappingStrategy();
        configuration.addPropertyMappingStrategy(customStrategy);
    }
}
