package com.kenshine.crane4j.Test05;

import cn.crane4j.annotation.Disassemble;
import cn.crane4j.core.executor.handler.ReflectiveDisassembleOperationHandler;

import java.util.List;

/**
 * @author by kenshine
 * @Classname Test03
 * @Description 拆卸处理器
 * @Date 2023-10-16 16:20
 * @modified By：
 * @version: 1.0$
 */
public class Test03Handler {
    // 拆卸处理器 可以实现自定义的拆卸操作处理器，并通过 handler 或 handlerType 属性进行指定
    // 目前默认的，也是唯一的拆卸操作处理就是 ReflectiveDisassembleOperationHandler
    public class Department {
        private Integer id;
        @Disassemble(
                type = Employee.class,
                handlerType = ReflectiveDisassembleOperationHandler.class // 指定操作处理器
        )
        private List<Employee> employees;
    }
}
