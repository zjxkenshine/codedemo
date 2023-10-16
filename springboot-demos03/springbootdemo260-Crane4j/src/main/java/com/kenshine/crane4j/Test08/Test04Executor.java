package com.kenshine.crane4j.Test08;

import cn.crane4j.annotation.Assemble;
import cn.crane4j.annotation.Mapping;
import cn.crane4j.annotation.Operator;
import cn.crane4j.core.executor.OrderedBeanOperationExecutor;
import cn.crane4j.core.parser.TypeHierarchyBeanOperationParser;

import java.util.Collection;
import java.util.Map;

/**
 * @author by kenshine
 * @Classname Test04Executor
 * @Description 指定执行器和解析器
 * @Date 2023-10-16 18:22
 * @modified By：
 * @version: 1.0$
 */
public class Test04Executor {
    // 指定执行器和解析器
    @Operator(
            executorType = OrderedBeanOperationExecutor.class,
            parserType = TypeHierarchyBeanOperationParser.class
    )
    private interface OperatorInterface {
        @Assemble(key = "id", container = "test", props = @Mapping(ref = "name"))
        void operate(Collection<Map<String, Object>> targets);
    }
}
