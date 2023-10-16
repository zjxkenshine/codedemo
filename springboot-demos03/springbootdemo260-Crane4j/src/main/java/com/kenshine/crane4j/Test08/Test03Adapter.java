package com.kenshine.crane4j.Test08;

import cn.crane4j.annotation.Assemble;
import cn.crane4j.annotation.ContainerParam;
import cn.crane4j.annotation.Mapping;
import cn.crane4j.annotation.Operator;
import cn.crane4j.core.container.Container;
import cn.crane4j.core.support.DataProvider;

import java.util.Collection;

/**
 * @author by kenshine
 * @Classname Test03Adapter
 * @Description 参数适配 处了可以将 Map 集合适配为容器外，也支持直接传入 Container，或 DataProvider 类型的参数
 * @Date 2023-10-16 18:18
 * @modified By：
 * @version: 1.0$
 */
public class Test03Adapter {
    @Operator
    private interface OperatorInterface {

        // 参数类型为 Container
        @Assemble(key = "id", container = "user", props = @Mapping("name"))
        void operate(Collection<Object> targets, @ContainerParam("user") Container<Integer> users);

        // 参数类型为 DataProvider
        @Assemble(key = "id", container = "user", props = @Mapping("name"))
        void operate(Collection<Object> targets, @ContainerParam("user") DataProvider<Integer, User> users);
    }


}
