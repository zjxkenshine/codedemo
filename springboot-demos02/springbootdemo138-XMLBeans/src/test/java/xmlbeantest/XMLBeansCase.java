package xmlbeantest;

import org.assertj.core.util.Lists;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3.tr.html4.school.GradeDocument;

import java.util.List;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/1 14:01
 * @description：XMLBeans操作XML
 * @modified By：
 * @version: $
 */
public class XMLBeansCase {
    private static Logger logger = LoggerFactory.getLogger(XMLBeansCase.class);

    /**
     * java对象转成xml
     * @throws Exception
     */
    @Test
    public void javaToXml() throws Exception {
        GradeDocument document = GradeDocument.Factory.newInstance();
        GradeDocument.Grade grade = document.addNewGrade();
        GradeDocument.Grade.Student student1 = grade.addNewStudent();
        student1.setRollno((byte) 1);
        student1.setAge((byte) 10);
        student1.setFirstname("cxx1");
        student1.setLastname("Bob1");
        student1.setNickname("stars1");
        student1.setMarks((byte) 85);

        GradeDocument.Grade.Student student2 = grade.addNewStudent();
        student2.setRollno((byte) 2);
        student2.setAge((byte) 11);
        student2.setFirstname("cxx2");
        student2.setLastname("Bob2");
        student2.setNickname("stars2");
        student2.setMarks((byte) 85);

        GradeDocument.Grade.Student student3 = grade.addNewStudent();
        student3.setRollno((byte) 3);
        student3.setAge((byte) 12);
        student3.setFirstname("cxx3");
        student3.setLastname("Bob3");
        student3.setNickname("stars3");
        student3.setMarks((byte) 85);
        document.save(System.out);
    }

    /**
     * xml转成java对象
     * @throws Exception
     */
    @Test
    public void xmlToJava() throws Exception {
        GradeDocument document = GradeDocument.Factory.parse(XMLBeansCase.class.getClassLoader().getResourceAsStream("xml/demo138.xml"));
        GradeDocument.Grade grade = document.getGrade();
        List<GradeDocument.Grade.Student> students = Lists.newArrayList(grade.getStudentArray());
        for (GradeDocument.Grade.Student student : students) {
            logger.info(student.getRollno() + "|" + student.getAge() + "|" + student.getFirstname() + "|" + student.getLastname() + "|" + student.getNickname());
        }
    }
}
