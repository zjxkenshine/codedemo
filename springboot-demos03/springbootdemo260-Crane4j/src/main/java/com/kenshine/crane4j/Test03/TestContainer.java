package com.kenshine.crane4j.Test03;

import cn.crane4j.annotation.Assemble;
import cn.crane4j.annotation.Mapping;
import cn.crane4j.core.container.Container;
import cn.crane4j.core.container.Containers;
import cn.crane4j.core.support.Crane4jGlobalConfiguration;
import cn.crane4j.core.support.SimpleCrane4jGlobalConfiguration;
import lombok.Data;

import java.util.HashMap;

/**
 * @author by kenshine
 * @Classname TestContainer
 * @Description 容器
 * @Date 2023-10-16 12:30
 * @modified By：
 * @version: 1.0$
 */
public class TestContainer {

    public void container(){
        // 基于 Map 集合创建容器，然后注册
        Crane4jGlobalConfiguration configuration = SimpleCrane4jGlobalConfiguration.create();
        Container<Integer> mapContainer = Containers.forMap("map_container", new HashMap<Integer, Object>());
        configuration.registerContainer(mapContainer);
    }

    // 在注解中通过命名空间引用容器
    @Data
    public class Student {
        @Assemble(container = "map_container", props = @Mapping(ref = "name"))
        private Integer id;
        private String name;
    }

}
