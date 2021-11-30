package saxtest;

import com.kenshine.sax.SaxHandler;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.helpers.AttributesImpl;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.sax.SAXTransformerFactory;
import javax.xml.transform.sax.TransformerHandler;
import javax.xml.transform.stream.StreamResult;
import java.io.ByteArrayOutputStream;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/30 22:51
 * @description：
 * @modified By：
 * @version: $
 */
public class SaxCase {
    private static Logger logger = LoggerFactory.getLogger(SaxCase.class);

    /**
     * 解析xml
     * @throws Exception
     */
    @Test
    public void parse() throws Exception {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        SaxHandler handler = new SaxHandler();
        parser.parse(SaxCase.class.getClassLoader().getResourceAsStream("xml/demo130.xml"), handler);
        logger.info(handler.getStudents().toString());
    }

    /**
     * 生成xml
     * @throws Exception
     */
    @Test
    public void toXml() throws Exception {
        //创建SAX转换工厂
        SAXTransformerFactory factory = (SAXTransformerFactory) SAXTransformerFactory.newInstance();
        TransformerHandler handler = factory.newTransformerHandler();

        //创建handler转换器
        Transformer transformer = handler.getTransformer();
        //换行
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty(OutputKeys.ENCODING, "utf-8");

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        StreamResult streamResult = new StreamResult(out);
        handler.setResult(streamResult);

        AttributesImpl attributes = new AttributesImpl();
        //打开doc对象
        handler.startDocument();
        handler.startElement("http://www.w3.org/TR/html4/school/", "", "school:class", null);

        //第一个学生
        attributes.clear();
        attributes.addAttribute("", "", "rollno", "", "1");
        attributes.addAttribute("", "", "school:age", "", "10");
        handler.startElement("", "", "student", attributes);
        handler.startElement("", "", "school:firstname", null);
        handler.characters("cxx1".toCharArray(), 0, 4);
        handler.endElement("", "", "school:firstname");
        handler.startElement("", "", "lastname", null);
        handler.characters("Bob1".toCharArray(), 0, 4);
        handler.endElement("", "", "lastname");
        handler.startElement("", "", "nickname", null);
        handler.characters("stars1".toCharArray(), 0, 6);
        handler.endElement("", "", "nickname");
        handler.startElement("", "", "marks", null);
        handler.characters("85".toCharArray(), 0, 2);
        handler.endElement("", "", "marks");
        handler.endElement("", "", "student");
        //第二个学生
        attributes.clear();
        attributes.addAttribute("", "", "rollno", "", "2");
        handler.startElement("", "", "student", attributes);
        handler.startElement("", "", "firstname", null);
        handler.characters("cxx2".toCharArray(), 0, 4);
        handler.endElement("", "", "firstname");
        handler.startElement("", "", "lastname", null);
        handler.characters("Bob2".toCharArray(), 0, 4);
        handler.endElement("", "", "lastname");
        handler.startElement("", "", "nickname", null);
        handler.characters("stars2".toCharArray(), 0, 6);
        handler.endElement("", "", "nickname");
        handler.startElement("", "", "marks", null);
        handler.characters("85".toCharArray(), 0, 2);
        handler.endElement("", "", "marks");
        handler.endElement("", "", "student");
        //第三个学生
        attributes.clear();
        attributes.addAttribute("", "", "rollno", "", "3");
        handler.startElement("", "", "student", attributes);
        handler.startElement("", "", "firstname", null);
        handler.characters("cxx3".toCharArray(), 0, 4);
        handler.endElement("", "", "firstname");
        handler.startElement("", "", "lastname", null);
        handler.characters("Bob3".toCharArray(), 0, 4);
        handler.endElement("", "", "lastname");
        handler.startElement("", "", "nickname", null);
        handler.characters("stars3".toCharArray(), 0, 6);
        handler.endElement("", "", "nickname");
        handler.startElement("", "", "marks", null);
        handler.characters("85".toCharArray(), 0, 2);
        handler.endElement("", "", "marks");
        handler.endElement("", "", "student");

        handler.endElement("", "", "school:class");

        handler.endDocument();
        logger.info(out.toString());
    }
}
