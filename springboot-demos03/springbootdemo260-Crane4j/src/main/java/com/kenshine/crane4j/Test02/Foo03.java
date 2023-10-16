package com.kenshine.crane4j.Test02;

import cn.crane4j.annotation.Assemble;
import cn.crane4j.annotation.Mapping;
import lombok.Data;

/**
 * @author by kenshine
 * @Classname Foo03
 * @Description 属性到键
 * @Date 2023-10-16 11:54
 * @modified By：
 * @version: 1.0$
 */
@Data
public class Foo03 {
    @Assemble(
            container = "gender",
            // src
            props = @Mapping(src = "name")  // gender.name -> studentVO.gender
    )
    private String gender;
}
