package com.kenshine.crane4j.Test04;

import cn.crane4j.annotation.AutoOperate;

import java.util.List;

/**
 * @author by kenshine
 * @Classname Test02Resolver
 * @Description 自动类型推断
 * @Date 2023-10-16 15:34
 * @modified By：
 * @version: 1.0$
 */
public class Test02Resolver {
    // 无法在编译期确定 getFooList 的返回值类型，因此没有指定 type 属性。在执行自动填充操作时，会动态推断类型
    // 通过类型解析器 TypeResolver 实现的
    @AutoOperate // 无法确定填充类型
    public <T> List<T> getFooList() {
        // do nothing
        return null;
    }
}
