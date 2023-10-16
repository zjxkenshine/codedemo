package com.kenshine.crane4j.Test03;

import cn.crane4j.annotation.Assemble;
import cn.crane4j.annotation.Mapping;
import cn.crane4j.core.container.Container;
import cn.crane4j.core.container.ContainerProvider;
import cn.crane4j.core.support.SimpleCrane4jGlobalConfiguration;
import org.checkerframework.checker.nullness.qual.Nullable;

/**
 * @author by kenshine
 * @Classname TestContainerProvider
 * @Description 自定义内容提供者
 * @Date 2023-10-16 15:11
 * @modified By：
 * @version: 1.0$
 */
public class TestContainerProvider {
    // 自定义ContainerProvider
    public class  XXXContainerProvider implements ContainerProvider{
        @Override
        public @Nullable <K> Container<K> getContainer(String s) {
            return null;
        }
    }

    public void test(){
        // 注册自定义ContainerProvider
        SimpleCrane4jGlobalConfiguration configuration = SimpleCrane4jGlobalConfiguration.create();
        configuration.registerContainerProvider("fooContainerProvider", new XXXContainerProvider());
    }

    // 引用自定义Provider
    public class UserVO {
        // 两种使用方式
        @Assemble(
                container = "user", containerProvider = "fooContainerProvider",
                props = @Mapping(src = "name", ref = "name")
        )
        @Assemble(
                container = "fooContainerProvider&&user",
                props = @Mapping(src = "name", ref = "name")
        )
        private Integer id;
        private String name;
    }
}
