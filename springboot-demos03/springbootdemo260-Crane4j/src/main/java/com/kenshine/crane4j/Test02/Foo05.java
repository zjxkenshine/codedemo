package com.kenshine.crane4j.Test02;

import cn.crane4j.annotation.Assemble;
import cn.crane4j.annotation.Mapping;
import lombok.Data;

import java.util.List;

/**
 * @author by kenshine
 * @Classname Foo05
 * @Description 批量映射
 * @Date 2023-10-16 12:09
 * @modified By：
 * @version: 1.0$
 */
@Data
public class Foo05 {
    @Assemble(
            container = "teacher",
            handler = "manyToManyAssembleOperationHandler",
            // [teacher, teacher...] -> [teacher.name, teacher.name...] -> studentVO.teacherNames
            props = @Mapping(src = "name", ref = "teacherNames")
    )
    private String teacherIds; // 以逗号分隔的字符串，例如：1, 2, 3 ManyToManyAssembleOperationHandler 定义分割器
    // private List<Integer> teacherIds; // 也可以直接是集合或者数组
    private List<String> teacherNames;
}
