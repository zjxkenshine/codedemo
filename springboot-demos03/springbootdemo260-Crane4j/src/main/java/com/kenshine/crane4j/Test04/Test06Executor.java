package com.kenshine.crane4j.Test04;

import cn.crane4j.annotation.AutoOperate;
import cn.crane4j.core.executor.OrderedBeanOperationExecutor;

import java.util.List;

/**
 * @author by kenshine
 * @Classname Test06Executor
 * @Description 执行器
 * @Date 2023-10-16 15:43
 * @modified By：
 * @version: 1.0$
 */
public class Test06Executor {
    //通过注解的 executor 属性可以指定本次填充操作的执行器
    // OrderedBeanOperationExecutor 将按照规定的顺序同步执行填充操作
    // AsyncBeanOperationExecutor 则支持并发填充
    // @AutoOperate(type = Foo.class, executorType = AsyncBeanOperationExecutor.class)
    @AutoOperate(type = Foo.class, executorType = OrderedBeanOperationExecutor.class)
    public List<Foo> getFoo(Integer type) {
        // do nothing
        return null;
    }
}
