package com.kenshine.btf.freezethaw;

import com.github.fge.Thawed;
import com.kenshine.btf.builder.User;

import javax.annotation.concurrent.NotThreadSafe;


/**
 * @author by kenshine
 * @Classname StudentBuilder
 * @Description
 * @Date 2024-04-19 16:01
 * @modified By：
 * @version: 1.0$
 * 可变类
 */
@NotThreadSafe
public class StudentBuilder<T extends Student> implements Thawed<Student> {
    private Integer id;
    private String name;


    public StudentBuilder<T> id(final Integer id) {
        this.id = id;
        return this;
    }

    public StudentBuilder<T> name(final String name) {
        this.name = name;
        return this;
    }

    @Override
    public Student freeze() {
        return new Student(id,name);
    }
}
