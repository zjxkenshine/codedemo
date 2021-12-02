package xstreamtest;

import com.kenshine.xstream.entity2.GradeXStream;
import com.kenshine.xstream.entity2.StudentXStream;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.QNameMap;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/2 8:43
 * @description：XStream注解的使用
 * @modified By：
 * @version: $
 */
@Slf4j
public class AnnotationCase {
    /**
     * java对象转成xml(注解)
     * @throws Exception
     */
    @Test
    public void javaToXmlAnnotation() {
        List<StudentXStream> students = new ArrayList<>();
        StudentXStream student1 = new StudentXStream(1, 11,"cxx1", "Bob1", "stars1", "85");
        StudentXStream student2 = new StudentXStream(2, 12, "cxx2", "Bob2", "stars2", "85");
        StudentXStream student3 = new StudentXStream(3, 13, "cxx3", "Bob3", "stars3", "85");
        students.add(student1);
        students.add(student2);
        students.add(student3);
        GradeXStream grade = new GradeXStream();
        grade.setStudents(students);

        QNameMap qNameMap = new QNameMap();
        qNameMap.setDefaultNamespace("http://www.w3.org/TR/html4/school/");
        qNameMap.setDefaultPrefix("school");

        XStream xstream = new XStream(new StaxDriver(qNameMap));
        xstream.autodetectAnnotations(true);
        String xml = xstream.toXML(grade);
        log.info(xml);
    }

    /**
     * xml转成java对象(注解)
     * @throws Exception
     */
    @Test
    public void xmlToJavaAnnotation() {
        QNameMap qNameMap = new QNameMap();
        qNameMap.setDefaultNamespace("http://www.w3.org/TR/html4/school/");
        qNameMap.setDefaultPrefix("school");

        XStream xstream = new XStream(new StaxDriver(qNameMap));
        xstream.ignoreUnknownElements();
        xstream.autodetectAnnotations(true);
        xstream.processAnnotations(GradeXStream.class);
        GradeXStream grade = (GradeXStream) xstream.fromXML(AnnotationCase.class.getClassLoader().getResourceAsStream("xml/demo140.xml"));
        log.info(grade.toString());
    }
}
