package com.kenshine.jaxb.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/1 9:43
 * @description：班级
 * @modified By：
 * @version: $
 */
@XmlRootElement(name = "grade", namespace = "http://www.w3.org/TR/html4/school/")
@XmlAccessorType(XmlAccessType.FIELD)
public class GradeJaxb {
    @XmlElement(name = "student", namespace = "http://www.w3.org/TR/html4/school/")
    private List<StudentJaxb> students;

    public List<StudentJaxb> getStudents() {
        return students;
    }

    public void setStudents(List<StudentJaxb> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "GradeJaxb{" +
                "students=" + students +
                '}';
    }
}
