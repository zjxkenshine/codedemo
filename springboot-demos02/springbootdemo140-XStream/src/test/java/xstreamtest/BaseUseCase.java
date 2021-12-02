package xstreamtest;

import com.kenshine.xstream.entity1.Grade;
import com.kenshine.xstream.entity1.Student;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.QNameMap;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/2 8:36
 * @description：基本使用
 * @modified By：
 * @version: $
 */
@Slf4j
public class BaseUseCase {

    /**
     * java对象转成xml
     * @throws Exception
     */
    @Test
    public void javaToXml() {
        List<Student> students = new ArrayList<>();
        Student student1 = new Student(1, 11,"cxx1", "Bob1", "stars1", "85");
        Student student2 = new Student(2, 12, "cxx2", "Bob2", "stars2", "85");
        Student student3 = new Student(3, 13, "cxx3", "Bob3", "stars3", "85");
        students.add(student1);
        students.add(student2);
        students.add(student3);
        Grade grade = new Grade();
        grade.setStudents(students);

        QNameMap qNameMap = new QNameMap();
        qNameMap.setDefaultNamespace("http://www.w3.org/TR/html4/school/");
        qNameMap.setDefaultPrefix("school");
//        qNameMap.registerMapping(new QName("http://www.w3.org/TR/html4/school/", "school"), ClassXStream.class);
        XStream xstream = new XStream(new StaxDriver(qNameMap));
        //设置类对应的节点名称
        xstream.alias("grade", Grade.class);
        xstream.alias("student", Student.class);
        //设置类字段对应的节点名称
        xstream.aliasField("age", Student.class, "age");
        xstream.aliasField("firstname", Student.class, "firstname");
        //省略集合根节点
        xstream.addImplicitCollection(Grade.class, "students");
        //把类字段设置成属性
        xstream.useAttributeFor(Student.class, "rollno");
        xstream.useAttributeFor(Student.class, "age");
        //隐藏类字段
        xstream.omitField(Student.class, "marks");

        String xml = xstream.toXML(grade);
        log.info(xml);
    }

    /**
     * xml转成java对象
     * @throws Exception
     */
    @Test
    public void xmlToJava() {
        QNameMap qNameMap = new QNameMap();
        qNameMap.setDefaultNamespace("http://www.w3.org/TR/html4/school/");
        qNameMap.setDefaultPrefix("school");
        XStream xstream = new XStream(new StaxDriver(qNameMap));
        xstream.ignoreUnknownElements();
        //设置类对应的节点名称
        xstream.alias("grade", Grade.class);
        xstream.alias("student", Student.class);
        //设置类字段对应的节点名称
        xstream.aliasField("age", Student.class, "age");
        xstream.aliasField("firstname", Student.class, "firstname");
        //省略集合根节点
        xstream.addImplicitCollection(Grade.class, "students");
        //把类字段设置成属性
        xstream.useAttributeFor(Student.class, "rollno");
        xstream.useAttributeFor(Student.class, "age");

        Grade grade = (Grade) xstream.fromXML(BaseUseCase.class.getClassLoader().getResourceAsStream("xml/demo140.xml"));
        log.info(grade.toString());
    }
}
