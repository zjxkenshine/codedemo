package jaxbtest;

import com.kenshine.jaxb.entity.GradeJaxb;
import com.kenshine.jaxb.entity.StudentJaxb;
import org.junit.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/1 9:46
 * @description：JAXB处理XML
 * @modified By：
 * @version: $
 */
public class JaxbCase {
    /**
     * java对象转成xml
     * @throws Exception
     */
    @Test
    public void javaToXml() throws Exception {
        List<StudentJaxb> students = new ArrayList<>();
        StudentJaxb student1 = new StudentJaxb(1, 11,"cxx1", "Bob1", "stars1", "85");
        StudentJaxb student2 = new StudentJaxb(2, 12, "cxx2", "Bob2", "stars2", "85");
        StudentJaxb student3 = new StudentJaxb(3, 13, "cxx3", "Bob3", "stars3", "85");
        students.add(student1);
        students.add(student2);
        students.add(student3);
        GradeJaxb grade = new GradeJaxb();
        grade.setStudents(students);

        //获取JAXB的上下文环境
        JAXBContext context = JAXBContext.newInstance(GradeJaxb.class);
        //创建Marshaller实例
        Marshaller marshaller = context.createMarshaller();
        //设置转换参数 -> 是否格式化输出
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        //是否隐藏xml声明
        marshaller.setProperty(Marshaller.JAXB_FRAGMENT, false);
        //构建输出环境 -> 这里输出到控制台Console
        PrintStream out = System.out;
        //将所需对象序列化 -> 该方法没有返回值
        marshaller.marshal(grade, out);
    }

    /**
     * xml转成java对象
     * @throws Exception
     */
    @Test
    public void xmlToJava() throws Exception {
        //获取JAXB的上下文环境
        JAXBContext context = JAXBContext.newInstance(GradeJaxb.class);
        //创建UnMarshaller实例
        Unmarshaller unmarshaller = context.createUnmarshaller();
        InputStream in = JaxbCase.class.getClassLoader().getResourceAsStream("xml/demo135.xml");
        //将XML数据序列化
        GradeJaxb grade = (GradeJaxb) unmarshaller.unmarshal(in);
        System.out.println(grade);
    }
}
