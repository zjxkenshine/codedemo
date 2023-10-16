package com.kenshine.crane4j.Test04;

import cn.crane4j.annotation.AutoOperate;

import java.util.List;

/**
 * @author by kenshine
 * @Classname Test04Condition
 * @Description 条件表达式
 * @Date 2023-10-16 15:40
 * @modified By：
 * @version: 1.0$
 */
public class Test04Condition {
    @AutoOperate(type = Foo.class, condition ="#type != 1 && ${config.enable-fill-foo}")
    public List<Foo> getFoo(Integer type) {
        // do nothing
        return null;
    }
}
