package com.kenshine.crane4j.Test01;

import cn.crane4j.annotation.Assemble;
import lombok.Data;

/**
 * @author by kenshine
 * @Classname Foo04
 * @Description 表达式
 * @Date 2023-10-16 11:39
 * @modified By：
 * @version: 1.0$
 */
@Data
public class Foo04 {
    @Assemble(container = "${custom.namespace}")
    //@Assemble(container = "${custom.namespace} + '$$defaultProvider'")
    private String name;
    private String alias;
}
