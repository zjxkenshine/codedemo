package staxtest;

import com.kenshine.stax.entity.Student;
import org.junit.Test;
import org.junit.platform.commons.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.namespace.QName;
import javax.xml.stream.*;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.XMLEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/30 23:08
 * @description：
 * @modified By：
 * @version: $
 */
public class StaxCase {
    private static Logger logger = LoggerFactory.getLogger(StaxCase.class);

    /**
     * 基于光标的方式解析xml
     * @throws Exception
     */
    @Test
    public void parse() throws Exception {
        XMLInputFactory factory = XMLInputFactory.newInstance();
        XMLStreamReader reader = factory.createXMLStreamReader(StaxCase.class.getClassLoader().getResourceAsStream("xml/demo131.xml"));
        //添加过滤器
        XMLStreamReader filterReader = factory.createFilteredReader(reader, new StreamFilter() {
            @Override
            public boolean accept(XMLStreamReader reader) {
                //处理开始节点
                if (reader.isStartElement() || reader.isEndElement() || reader.isCharacters()) {
                    return true;
                }
                return false;
            }
        });

        List<Student> students = new ArrayList<>();
        Student student = null;
        String text = "";
        while (filterReader.hasNext()) {
            int type = filterReader.next();
            if (type == XMLStreamReader.START_ELEMENT) {
                if ("student".equals(reader.getName().getLocalPart())) {
                    student = new Student();
                    students.add(student);

                    student.setRollno(Integer.parseInt(reader.getAttributeValue("", "rollno")));
                    String age = reader.getAttributeValue("http://www.w3.org/TR/html4/school/", "age");
                    if (StringUtils.isNotBlank(age)) {
                        student.setAge(Integer.parseInt(age));
                    }
                }
            } else if (type == XMLStreamReader.END_ELEMENT) {
                logger.info(reader.getName().getLocalPart());
                if ("firstname".equals(reader.getName().getLocalPart())) {
                    student.setFirstname(text);
                } else if ("lastname".equals(reader.getName().getLocalPart())) {
                    student.setLastname(text);
                } else if ("nickname".equals(reader.getName().getLocalPart())) {
                    student.setNickname(text);
                } else if ("marks".equals(reader.getName().getLocalPart())) {
                    student.setMarks(text);
                }

            } else if (type == XMLStreamReader.CHARACTERS) {
                text = reader.getText();
            }
        }
        logger.info(students.toString());
    }

    /**
     * 基于迭代模型的方式解析xml
     * @throws Exception
     */
    @Test
    public void parse2() throws Exception {
        XMLInputFactory factory = XMLInputFactory.newInstance();
        XMLEventReader reader = factory.createXMLEventReader(StaxCase.class.getClassLoader().getResourceAsStream("xml/demo131.xml"));
        //添加过滤器
        XMLEventReader filterReader = factory.createFilteredReader(reader, event -> {
            //处理开始节点
            if (event.isStartElement() || event.isEndElement() || event.isCharacters()) {
                return true;
            }
            return false;
        });

        List<Student> students = new ArrayList<>();
        Student student = null;
        String text = "";
        while (filterReader.hasNext()) {
            XMLEvent event = filterReader.nextEvent();
            if (event.isStartElement()) {
                if ("student".equals(event.asStartElement().getName().getLocalPart())) {
                    student = new Student();
                    students.add(student);

                    student.setRollno(Integer.parseInt(event.asStartElement().getAttributeByName(new QName("", "rollno")).getValue()));
                    Attribute ageAttribute = event.asStartElement().getAttributeByName(new QName("http://www.w3.org/TR/html4/school/", "age"));
                    if (ageAttribute != null) {
                        student.setAge(Integer.parseInt(ageAttribute.getValue()));
                    }
                }
            } else if (event.isEndElement()) {
                logger.info(event.asEndElement().getName().getLocalPart());
                if ("firstname".equals(event.asEndElement().getName().getLocalPart())) {
                    student.setFirstname(text);
                } else if ("lastname".equals(event.asEndElement().getName().getLocalPart())) {
                    student.setLastname(text);
                } else if ("nickname".equals(event.asEndElement().getName().getLocalPart())) {
                    student.setNickname(text);
                } else if ("marks".equals(event.asEndElement().getName().getLocalPart())) {
                    student.setMarks(text);
                }
            } else if (event.isCharacters()) {
                text = event.asCharacters().getData();
            }
        }
        logger.info(students.toString());
    }

    /**
     * 生成xml
     * @throws Exception
     */
    @Test
    public void toXml() throws Exception {
        XMLOutputFactory factory = XMLOutputFactory.newInstance();
        XMLStreamWriter writer = factory.createXMLStreamWriter(System.out);
        writer.writeStartDocument("UTF-8", "1.0");
        writer.writeStartElement("school", "class", "http://www.w3.org/TR/html4/school/");

        //第一个学生
        writer.writeStartElement("school", "student", "http://www.w3.org/TR/html4/school/");
        writer.writeAttribute("rollno", "1");
        writer.writeAttribute("school","http://www.w3.org/TR/html4/school/", "age", "10");
        writer.writeStartElement("school", "firstname", "http://www.w3.org/TR/html4/school/");
        writer.writeCharacters("cxx1");
        writer.writeEndElement();
        writer.writeStartElement("lastname");
        writer.writeCharacters("Bob1");
        writer.writeEndElement();
        writer.writeStartElement("nickname");
        writer.writeCharacters("stars1");
        writer.writeEndElement();
        writer.writeStartElement("marks");
        writer.writeCharacters("85");
        writer.writeEndElement();
        writer.writeEndElement();

        //第二个学生
        writer.writeStartElement("student");
        writer.writeAttribute("rollno", "2");
        writer.writeStartElement("firstname");
        writer.writeCharacters("cxx2");
        writer.writeEndElement();
        writer.writeStartElement("lastname");
        writer.writeCharacters("Bob2");
        writer.writeEndElement();
        writer.writeStartElement("nickname");
        writer.writeCharacters("stars2");
        writer.writeEndElement();
        writer.writeStartElement("marks");
        writer.writeCharacters("85");
        writer.writeEndElement();
        writer.writeEndElement();

        //第三个学生
        writer.writeStartElement("student");
        writer.writeAttribute("rollno", "3");
        writer.writeStartElement("firstname");
        writer.writeCharacters("cxx3");
        writer.writeEndElement();
        writer.writeStartElement("lastname");
        writer.writeCharacters("Bob3");
        writer.writeEndElement();
        writer.writeStartElement("nickname");
        writer.writeCharacters("stars3");
        writer.writeEndElement();
        writer.writeStartElement("marks");
        writer.writeCharacters("85");
        writer.writeEndElement();
        writer.writeEndElement();

        writer.writeEndElement();
        writer.writeEndDocument();
    }
}