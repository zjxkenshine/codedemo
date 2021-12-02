package xpp3test;

import com.kenshine.xpp3.Student;
import org.junit.Test;
import org.junit.platform.commons.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/2 8:16
 * @description：
 * @modified By：
 * @version: $
 */
public class Xpp3Case {
    private static Logger logger = LoggerFactory.getLogger(Xpp3Case.class);

    /**
     * 解析xml
     * @throws Exception
     */
    @Test
    public void parse() throws Exception {
        XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
        factory.setNamespaceAware(true);
        XmlPullParser xpp = factory.newPullParser();
        xpp.setInput(Xpp3Case.class.getClassLoader().getResourceAsStream("xml/demo139.xml"), "utf-8");

        List<Student> students = new ArrayList<>();
        Student student = null;
        String text = "";
        int eventType = xpp.getEventType();
        while (true) {
            if (eventType == XmlPullParser.START_DOCUMENT) {
                logger.info("Start of Document");
            } else if (eventType == XmlPullParser.START_TAG) {
                if ("student".equals(xpp.getName())) {
                    student = new Student();
                    students.add(student);
                    student.setRollno(Integer.parseInt(xpp.getAttributeValue("", "rollno")));
                    String age = xpp.getAttributeValue("http://www.w3.org/TR/html4/school/", "age");
                    if (StringUtils.isNotBlank(age)) {
                        student.setAge(Integer.parseInt(age));
                    }
                }
            } else if (eventType == XmlPullParser.END_TAG) {
                if ("firstname".equals(xpp.getName())) {
                    student.setFirstname(text);
                } else if ("lastname".equals(xpp.getName())) {
                    student.setLastname(text);
                } else if ("nickname".equals(xpp.getName())) {
                    student.setNickname(text);
                } else if ("marks".equals(xpp.getName())) {
                    student.setMarks(text);
                }
            } else if (eventType == XmlPullParser.TEXT) {
                text = xpp.getText();
            } else if (eventType == XmlPullParser.END_DOCUMENT) {
                logger.info("End of Document");
                break;
            }
            eventType = xpp.next();
        }

        logger.info(students.toString());
    }
}
