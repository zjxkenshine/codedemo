package com.kenshine.crane4j.Test06;

import cn.crane4j.annotation.Assemble;
import cn.crane4j.annotation.AutoOperate;
import cn.crane4j.annotation.Mapping;
import cn.crane4j.core.executor.OrderedBeanOperationExecutor;

import java.util.List;

/**
 * @author by kenshine
 * @Classname Test06Order2
 * @Description TODO
 * @Date 2023-10-16 16:57
 * @modified By：
 * @version: 1.0$
 */
public class Test06Order2 {
    public class Student {

        @Assemble(
                container = "student", sort = 0,
                props = { @Mapping("name"), @Mapping("classroomId") }
        )
        private Integer id;
        private String name;

        @Assemble(
                container = "classroot", sort = 1,
                props = {
                        @Mapping(src ="name", ref = "classroomName"),
                        @Mapping(src ="headTeacherId", ref = "headTeacherId"),
                }
        )
        private Integer classroomId;
        private Integer classroomName;

        @Assemble(
                container = "teacher", sort = 2,
                props = @Mapping(src = "name", ref = "headTeacherName")
        )
        private Integer headTeacherId;
        private Integer headTeacherName;
    }

    // 显式指定操作执行器
    // 终的执行顺序要通过 BeanOperationExecutor 来保证，如果你希望按顺序执行，则需要手动的指定操作执行器为有序执行器 OrderedBeanOperationExecutor ：
    @AutoOperate(type = Student.class, executorType = OrderedBeanOperationExecutor.class)
    public List<Student> listStudent(List<Integer> ids) {
        // do something
        return null;
    }
}
