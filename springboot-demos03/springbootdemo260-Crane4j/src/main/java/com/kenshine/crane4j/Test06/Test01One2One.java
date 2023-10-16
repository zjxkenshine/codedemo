package com.kenshine.crane4j.Test06;

import cn.crane4j.annotation.Assemble;

/**
 * @author by kenshine
 * @Classname Test01One2One
 * @Description 一对一
 * @Date 2023-10-16 16:25
 * @modified By：
 * @version: 1.0$
 */
public class Test01One2One {
    public class Foo {
        @Assemble(container = "foo", handler = "oneToOneAssembleOperationHandler")
        private String name;
        private String alias;
    }
}
