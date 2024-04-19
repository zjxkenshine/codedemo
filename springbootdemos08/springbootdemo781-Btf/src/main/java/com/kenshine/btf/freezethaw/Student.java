package com.kenshine.btf.freezethaw;

import com.github.fge.Frozen;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.junit.Test;

import javax.annotation.concurrent.Immutable;

/**
 * @author by kenshine
 * @Classname Student 不可变类
 * @Description
 * @Date 2024-04-19 16:01
 * @modified By：
 * @version: 1.0$
 */
@Immutable
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Student implements Frozen<StudentBuilder<Student>> {
    private Integer id;
    private String name;

    @Override
    public StudentBuilder<Student> thaw() {
        return new StudentBuilder<>().id(id).name(name);
    }
}
