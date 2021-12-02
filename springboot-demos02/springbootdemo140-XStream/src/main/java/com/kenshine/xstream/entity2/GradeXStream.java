package com.kenshine.xstream.entity2;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

import java.util.List;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/2 8:33
 * @description：班级(使用注解)
 * @modified By：
 * @version: $
 */
@XStreamAlias("grade")
public class GradeXStream {
    @XStreamImplicit
    private List<StudentXStream> students;

    public List<StudentXStream> getStudents() {
        return students;
    }

    public void setStudents(List<StudentXStream> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "GradeXStream{" +
                "students=" + students +
                '}';
    }
}
