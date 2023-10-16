package com.kenshine.crane4j.Test04;

import cn.crane4j.annotation.AutoOperate;

import java.util.List;

/**
 * @author by kenshine
 * @Classname Test05Group
 * @Description 分组
 * @Date 2023-10-16 15:41
 * @modified By：
 * @version: 1.0$
 */
public class Test05Group {
    // 只会完成带有 base 或 foo 组别的装配/拆卸操作
    @AutoOperate(type = Foo.class, includes = {"base", "foo"})
    public List<Foo> getFoo(Integer type) {
        // do nothing
        return null;
    }
}
