package com.kenshine.crane4j.Test05;

import cn.crane4j.annotation.Disassemble;

import java.util.List;

/**
 * @author by kenshine
 * @Classname Test02Resolve
 * @Description 自动推断类型
 * @Date 2023-10-16 16:19
 * @modified By：
 * @version: 1.0$
 */
public class Test02Resolve {
    // 无法在编译期确定要填充的对象类型。此时，可以不指定 type 属性，而是在执行拆卸操作时动态推断类型
    // TypeResolver 可以提供自己的实现类来替换默认的类型解析器
    public class Department<T> {
        private Integer id;
        @Disassemble // 无法确定填充类型
        private List<T> employees;
    }
}
