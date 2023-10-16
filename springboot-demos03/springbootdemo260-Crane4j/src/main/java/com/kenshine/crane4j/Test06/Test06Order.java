package com.kenshine.crane4j.Test06;

import cn.crane4j.annotation.Assemble;
import cn.crane4j.annotation.Mapping;

/**
 * @author by kenshine
 * @Classname Test06Order
 * @Description 执行顺序
 * @Date 2023-10-16 16:56
 * @modified By：
 * @version: 1.0$
 */
public class Test06Order {
    public class Student {

        // id1 -> id2
        @Assemble(container = "id", sort = 0, props = @Mapping(ref = "id2"))
        private Integer id1;

        // id2 -> id3
        @Assemble(container = "id", sort = 1, props = @Mapping(ref = "id3"))
        private Integer id2;

        // id3 -> id4
        @Assemble(container = "id", sort = 2, props = @Mapping(ref = "id4"))
        private Integer id3;
        private Integer id4;
    }
}
