package xstreamtest;

import com.kenshine.xstream.convert.GradeConvert;
import com.kenshine.xstream.entity1.Grade;
import com.kenshine.xstream.entity1.Student;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.QNameMap;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/2 8:39
 * @description：自定义转换器的使用
 * @modified By：
 * @version: $
 */
@Slf4j
public class ConvertUseCase{
    /**
     * java对象转成xml(自定义转换器)
     * @throws Exception
     */
    @Test
    public void javaToXmlCustomerConvert() {
        List<Student> students = new ArrayList<>();
        Student student1 = new Student(1, 11,"cxx1", "Bob1", "stars1", "85");
        Student student2 = new Student(2, 12, "cxx2", "Bob2", "stars2", "85");
        Student student3 = new Student(3, 13, "cxx3", "Bob3", "stars3", "85");
        students.add(student1);
        students.add(student2);
        students.add(student3);
        Grade grade = new Grade();
        grade.setStudents(students);

        XStream xstream = new XStream(new StaxDriver());
        xstream.alias("school:grade", Grade.class);
        xstream.registerConverter(new GradeConvert());
        String xml = xstream.toXML(grade);
        log.info(xml);
    }

    /**
     * xml转成java对象(自定义转换器)
     * @throws Exception
     */
    @Test
    public void xmlToJavaCustomerConvert() {
        QNameMap qNameMap = new QNameMap();
        qNameMap.setDefaultNamespace("http://www.w3.org/TR/html4/school/");
        qNameMap.setDefaultPrefix("school");
        XStream xstream = new XStream(new StaxDriver(qNameMap));
        xstream.alias("grade", Grade.class);
        xstream.ignoreUnknownElements();
        xstream.registerConverter(new GradeConvert());
        Grade grade = (Grade) xstream.fromXML(ConvertUseCase.class.getClassLoader().getResourceAsStream("xml/demo140.xml"));
        log.info(grade.toString());
    }
}
