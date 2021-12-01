package castortest;

import com.kenshine.castorxml.entity.Grade;
import com.kenshine.castorxml.entity.Student;
import org.exolab.castor.mapping.Mapping;
import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStreamReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/1 10:11
 * @description：Castor操作XML
 * @modified By：
 * @version: $
 */
public class CastorCase {
    private static Logger logger = LoggerFactory.getLogger(CastorCase.class);

    /**
     * java对象转成xml
     * @throws Exception
     */
    @Test
    public void javaToXml() throws Exception {
        List<Student> students = new ArrayList<>();
        Student student1 = new Student(1, 11,"cxx1", "Bob1", "stars1", "85");
        Student student2 = new Student(2, 12, "cxx2", "Bob2", "stars2", "85");
        Student student3 = new Student(3, 13, "cxx3", "Bob3", "stars3", "85");
        students.add(student1);
        students.add(student2);
        students.add(student3);
        Grade grade = new Grade();
        grade.setStudents(students);

        StringWriter sw = new StringWriter();
        //Marshaller接口将Java对象转换为XML
        Marshaller marshaller = new Marshaller(sw);
        Mapping mapping = new Mapping();
        mapping.loadMapping(Objects.requireNonNull(CastorCase.class.getClassLoader().getResource("map/mapping.xml")));
        marshaller.setMapping(mapping);
        marshaller.marshal(grade);
        logger.info(sw.toString());
    }

    /**
     * xml转成java对象
     * @throws Exception
     */
    @Test
    public void xmlToJava() throws Exception {
        InputStreamReader reader = new InputStreamReader(CastorCase.class.getClassLoader().getResourceAsStream("xml/demo136.xml"));
        //Unmarshaller接口将XML转换为Java对象
        Unmarshaller unmarshaller = new Unmarshaller(Grade.class);
        Mapping mapping = new Mapping();
        mapping.loadMapping(Objects.requireNonNull(CastorCase.class.getClassLoader().getResource("map/mapping.xml")));
        unmarshaller.setMapping(mapping);
//        Classes classes = (Classes) Unmarshaller.unmarshal(Classes.class, reader);
        Grade grade = (Grade) unmarshaller.unmarshal(reader);
        logger.info(grade.toString());
    }
}
