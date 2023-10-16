package com.kenshine.crane4j.Test06;

import cn.crane4j.annotation.ArgAutoOperate;
import cn.crane4j.annotation.AutoOperate;

import java.util.List;

/**
 * @author by kenshine
 * @Classname Test05GroupExecute
 * @Description 按组执行
 * @Date 2023-10-16 16:53
 * @modified By：
 * @version: 1.0$
 *
 * // 如果目标对象所属的填充组与指定的任何一个组匹配，执行填充操作
 * executeIfMatchAnyGroups(Object target, String... groups);
 *
 * // 如果目标对象所属的填充组与指定的任何一个组都不匹配，执行填充操作
 * executeIfNoneMatchAnyGroups(Object target, String... groups);
 *
 * // 如果目标对象所属的填充组与指定的所有组都匹配，执行填充操作
 * executeIfMatchAllGroups(Object target, String... groups);
 *
 * // 仅执行通过指定过滤器条件的操作
 * execute(Object target, Predicate<? super KeyTriggerOperation> filter);
 */
public class Test05GroupExecute {
    // 填充返回值
    @AutoOperate(type = Test04Group.Foo.class, includes = "base")
    public List<Test04Group.Foo> getFooList() {
        // do nothing
        return null;
    }

    // 填充参数
    @ArgAutoOperate(
            @AutoOperate(value = "foos", type = Test04Group.Foo.class, includes = "base")
    )
    public void setFooList(List<Test04Group.Foo> foos) {
        // do nothing
    }
}
