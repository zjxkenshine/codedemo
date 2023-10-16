package com.kenshine.crane4j.Test03;

import cn.crane4j.annotation.ContainerMethod;

import java.util.List;
import java.util.Set;

/**
 * @author by kenshine
 * @Classname Test05Method
 * @Description 方法容器声明
 * @Date 2023-10-16 13:45
 * @modified By：
 * @version: 1.0$
 */
public class Test05Method {

    // 声明在方法上
    @ContainerMethod(
            namespace = "onoToOneMethod",
            resultType = Foo.class, resultKey = "id" // 返回的数据源对象类型为 Foo，并且需要按 id 分组
    )
    public Set<Foo> onoToOneMethod(List<String> args) {
        // do something
        return null;
    }


    // 声明在类上
    // 父类
    public class SuperClass {
        public Set<Foo> onoToOneMethod(List<String> args) {
            // do something
            return null;
        }
    }

    // 子类
    @ContainerMethod(
            namespace = "onoToOneMethod",
            resultType = Foo.class, resultKey = "id", // 返回的数据源对象类型为 Foo，并且需要按 id 分组
            bindMethod = "onoToOneMethod",// 指定要绑定的方法名称
            bindMethodParamTypes = List.class // 指定要绑定方法的参数类型
    )
    public class ChildClass extends SuperClass {}
}
