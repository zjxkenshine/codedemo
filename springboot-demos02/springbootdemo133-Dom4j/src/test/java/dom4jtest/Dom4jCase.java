package dom4jtest;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/1 8:39
 * @description：DOM4J处理XML
 * @modified By：
 * @version: $
 */
public class Dom4jCase {
    private static Logger logger = LoggerFactory.getLogger(Dom4jCase.class);

    /**
     * 解析xml
     * @throws Exception
     */
    @Test
    public void parse() throws Exception {
        SAXReader reader = new SAXReader();
        Document document = reader.read(Dom4jCase.class.getClassLoader().getResourceAsStream("xml/demo133.xml"));
        //Document document = DocumentHelper.parseText(xmlString);//解析字符串
        Element root = document.getRootElement();
        List<Element> list = root.elements("student");
        for (Element student : list) {
            logger.info("学生编号{}", student.attributeValue("rollno"));
            logger.info("age:{}", student.attributeValue("age"));
            logger.info("firstname:{}", student.elementText("firstname"));
            logger.info("lastname:{}", student.elementText("lastname"));
            logger.info("nickname:{}", student.elementText("nickname"));
            logger.info("marks:{}", student.elementText("marks"));
        }
    }

    /**
     * xpath使用
     * @throws Exception
     */
    @Test
    public void xpath() throws Exception {
        SAXReader reader = new SAXReader();
        Document document = reader.read(Dom4jCase.class.getClassLoader().getResourceAsStream("xml/demo133.xml"));
        logger.info("查找所有的存在rollno属性的student节点，取出lastname的值");
        List<Node> list = document.selectNodes("//student[@rollno]/lastname/text()");//第二、三位学生
//        List<Node> list = document.selectNodes("//student[@rollno]/child::lastname/test()");//效果同上
        for (Node node : list) {
            logger.info(node.getText());
        }

        logger.info("查找所有的存在rollno属性的student节点");
        list = document.selectNodes("//school:student[@rollno]");//第一位学生
        for (Node node : list) {
            //获取rollno的属性值
            logger.info(node.valueOf("@rollno"));
        }

    }

    /**
     * 生成xml
     */
    @Test
    public void toXml() throws IOException {
        Document document = DocumentHelper.createDocument();
        Element root = document.addElement("school:class", "http://www.w3.org/TR/html4/school/");
        //第一个学生
        Element student = root.addElement("school:student");
        student.addAttribute("rollno", "1");
        student.addAttribute("school:age", "10");
        student.addElement("school:firstname").setText("cxx1");
        student.addElement("lastname").setText("Bob1");
        student.addElement("nickname").setText("stars1");
        student.addElement("marks").setText("85");
        //第二个学生
        student = root.addElement("student");
        student.addAttribute("rollno", "2");
        student.addElement("school:firstname").setText("cxx2");
        student.addElement("lastname").setText("Bob2");
        student.addElement("nickname").setText("stars2");
        student.addElement("marks").setText("85");
        //第三个学生
        student = root.addElement("student");
        student.addAttribute("rollno", "3");
        student.addElement("school:firstname").setText("cxx3");
        student.addElement("lastname").setText("Bob3");
        student.addElement("nickname").setText("stars3");
        student.addElement("marks").setText("85");

        //直接转成字符串
//      logger.info(document.asXML());

        //格式化并输出到输出流
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        OutputFormat format = OutputFormat.createPrettyPrint();
        XMLWriter writer = new XMLWriter(out, format);
        writer.write(document);
        logger.info(out.toString());
    }
}
