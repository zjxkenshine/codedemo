package com.kenshine.crane4j.Test06;

import cn.crane4j.annotation.Assemble;
import cn.crane4j.annotation.Mapping;
import cn.crane4j.core.executor.handler.ManyToManyAssembleOperationHandler;
import com.kenshine.crane4j.Test03.SpringUtils;
import lombok.Data;

import java.util.List;
import java.util.Set;

/**
 * @author by kenshine
 * @Classname Test
 * @Description 多对多
 * @Date 2023-10-16 16:46
 * @modified By：
 * @version: 1.0$
 */
public class Test03N2N {
    private String idStr; // 键字段为按分隔符拼接的字符串，例如："a, b, c"
    private Set<Integer> idList; // 键字段为集合，例如：[a, b, c]
    private Integer[] idArray; // 键字段为数组，例如：[a, b, c]

    public class StudentVO {
        @Assemble(
                container = "teacher",
                // ManyToManyAssembleOperationHandler 多对多处理
                handler = "manyToManyAssembleOperationHandler",
                props = @Mapping(src = "name", ref = "teacherNames")
        )
        private String teacherIds; // 默认支持 "1, 2, 3" 格式
        private List<String> teacherNames; // 填充的格式默认为 src1, src2, src3
    }

    public class StudentVO1 {
        @Assemble(
                container = "teacher",
                props = @Mapping(ref = "teachers"),
                handler = "manyToManyAssembleOperationHandler"
        )
        private String teacherIds; // 默认支持 "1, 2, 3" 格式
        private List<Teacher> teachers;
    }

    @Data
    public class Teacher {
    }

    // 自定义分隔符
    public void Test(){
        ManyToManyAssembleOperationHandler handler = SpringUtils.getBean(ManyToManyAssembleOperationHandler.class);
        // 按 | 分割
        handler.setKeySplitter(k -> new ManyToManyAssembleOperationHandler.DefaultSplitter("|").apply("keys"));
    }
}
