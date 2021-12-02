package com.kenshine.xstream.convert;

import com.kenshine.xstream.entity1.Grade;
import com.kenshine.xstream.entity1.Student;
import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/2 8:41
 * @description：自定义转换器
 * @modified By：
 * @version: $
 */
public class GradeConvert implements Converter {
    /**
     * Java对象转成XML
     */
    @Override
    public void marshal(Object o, HierarchicalStreamWriter writer, MarshallingContext context) {
        Grade grade = (Grade) o;
        List<Student> students = grade.getStudents();
        writer.addAttribute("xmlns:school", "http://www.w3.org/TR/html4/school/");
        for (Student student : students) {
            writer.startNode("school:student");
            writer.addAttribute("rollno", student.getRollno() + "");
            writer.addAttribute("age", student.getAge() + "");
            writer.startNode("school:firstname");
            writer.setValue(student.getFirstname());
            writer.endNode();
            writer.startNode("school:lastname");
            writer.setValue(student.getLastname());
            writer.endNode();
            writer.startNode("school:nickname");
            writer.setValue(student.getNickname());
            writer.endNode();
            writer.startNode("school:marks");
            writer.setValue(student.getMarks());
            writer.endNode();
            writer.endNode();
        }
    }

    /**
     * XML转Java对象
     */
    @Override
    public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {
        Grade grade = new Grade();
        List<Student> students = new ArrayList<>();
        grade.setStudents(students);
        while (reader.hasMoreChildren()) {
            Student student = new Student();
            students.add(student);
            reader.moveDown();
            student.setRollno(Integer.parseInt(reader.getAttribute("rollno")));
            student.setAge(Integer.parseInt(reader.getAttribute("age")));
            reader.moveDown();
            student.setFirstname(reader.getValue());
            reader.moveUp();
            reader.moveDown();
            student.setLastname(reader.getValue());
            reader.moveUp();
            reader.moveDown();
            student.setNickname(reader.getValue());
            reader.moveUp();
            reader.moveDown();
            student.setMarks(reader.getValue());
            reader.moveUp();
            reader.moveUp();
        }
        return grade;
    }

    @Override
    public boolean canConvert(Class type) {
        return type.equals(Grade.class);
    }
}
