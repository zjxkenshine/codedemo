package com.kenshine.sax;

import com.kenshine.entity.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/30 22:52
 * @description：
 * @modified By：
 * @version: $
 *
 * Sax处理器
 */
public class SaxHandler extends DefaultHandler {
    private String text;
    private static Logger logger = LoggerFactory.getLogger(SaxHandler.class);

    private List<Student> students = new ArrayList<>();
    private Student student = null;

    public List<Student> getStudents() {
        return students;
    }

    public SaxHandler() {}

    @Override
    public void startDocument() throws SAXException {
        super.startDocument();
        logger.info("SAX解析开始");
    }

    @Override
    public void endDocument() throws SAXException {
        super.endDocument();
        logger.info("SAX解析结束");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        super.startElement(uri, localName, qName, attributes);
        logger.info("qName={}", qName);
        if (qName.equals("student") || qName.equals("school:student")) {
            student = new Student();
            students.add(student);

            student.setRollno(Integer.parseInt(attributes.getValue("rollno")));
            String age = attributes.getValue("school:age");
            if (Objects.nonNull(age)) {
                student.setAge(Integer.parseInt(age));
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName)
            throws SAXException {
        super.endElement(uri, localName, qName);
        if ("firstname".equals(qName) || "school:firstname".equals(qName) ) {
            student.setFirstname(text);
        } else if ("lastname".equals(qName)) {
            student.setLastname(text);
        } else if ("nickname".equals(qName)) {
            student.setNickname(text);
        } else if ("marks".equals(qName)) {
            student.setMarks(text);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        super.characters(ch, start, length);
        text = new String(ch, start, length);
    }
}
