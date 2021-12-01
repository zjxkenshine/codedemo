package jdomtest;

import org.jdom2.*;
import org.jdom2.filter.Filter;
import org.jdom2.filter.Filters;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;
import org.jdom2.xpath.XPathBuilder;
import org.jdom2.xpath.XPathExpression;
import org.jdom2.xpath.XPathFactory;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/1 8:12
 * @description：
 * @modified By：
 * @version: $
 */
public class JDomCase {
    private static Logger logger = LoggerFactory.getLogger(JDomCase.class);

    /**
     * 解析xml
     * @throws Exception
     */
    @Test
    public void parse() throws Exception {
        SAXBuilder sb = new SAXBuilder();
        Document document = sb.build(JDomCase.class.getClassLoader().getResourceAsStream("xml/demo132.xml"));
        //根元素
        Element root = document.getRootElement();
        //命名空间
        Namespace namespace = Namespace.getNamespace("school", "http://www.w3.org/TR/html4/school/");
        List<Element> list = root.getChildren("student", namespace);//第1位学生
        for (int i = 0; i < list.size(); i++) {
            Element student = list.get(i);
            logger.info("学生编号{}", student.getAttributeValue("rollno"));
            logger.info("age:{}", student.getAttributeValue("age", namespace));
            logger.info("firstname:{}", student.getChildText("firstname", namespace));
            logger.info("lastname:{}", student.getChildText("lastname"));
            logger.info("nickname:{}", student.getChildText("nickname"));
            logger.info("marks:{}", student.getChildText("marks"));
        }

        list = root.getChildren("student");//第2、3位学生
        for (int i = 0; i < list.size(); i++) {
            Element student = list.get(i);
            logger.info("学生编号{}",student.getAttributeValue("rollno"));
            logger.info("firstname:{}", student.getChildText("firstname"));
            logger.info("lastname:{}", student.getChildText("lastname"));
            logger.info("nickname:{}", student.getChildText("nickname"));
            logger.info("marks:{}", student.getChildText("marks"));
        }
    }

    /**
     * xpath使用
     */
    @Test
    public void xpath() throws JDOMException, IOException {
        SAXBuilder sb = new SAXBuilder();
        Document document = sb.build(JDomCase.class.getClassLoader().getResourceAsStream("xml/demo132.xml"));
        Namespace namespace = Namespace.getNamespace("school", "http://www.w3.org/TR/html4/school/");

        Filter<Text> filter = Filters.text();
        logger.info("查找所有的存在rollno属性的student节点，取出lastname的值");
        XPathBuilder<Text> builder = new XPathBuilder<>("//student[@rollno]/lastname/text()", filter);//第2、3位学生
//        XPathBuilder<Text> builder = new XPathBuilder<Text>("//student[@rollno]/child::lastname/text()", filter);//效果同上
//        XPathBuilder<Text> builder = new XPathBuilder<Text>("//school:student[@rollno]/lastname/text()", filter);//第1位学生
        builder.setNamespace(namespace);
        XPathExpression<Text> expression = builder.compileWith(XPathFactory.instance());
        //XPathExpression<Object> expression = XPathFactory.instance().compile("//student[@rollno]/lastname/text()");
        List<Text> list = expression.evaluate(document);
        for (Text text : list) {
            logger.info(text.getText());
        }
    }

    /**
     * 生成xml
     */
    @Test
    public void toXml() throws IOException {
        Document document = new Document();
        Namespace namespace = Namespace.getNamespace("school", "http://www.w3.org/TR/html4/school/");
        Element root = new Element("class", namespace);
        document.setRootElement(root);
        //第一个学生
        Element student = new Element("student", namespace);
        student.setAttribute(new Attribute("rollno", "1"));
        student.setAttribute(new Attribute("age", "10", namespace));
        Element firstname = new Element("firstname", namespace).setText("cxx1");
        Element lastname = new Element("lastname").setText("Bob1");
        Element nickname = new Element("nickname").setText("stars1");
        Element marks = new Element("marks").setText("85");

        student.addContent(firstname);
        student.addContent(lastname);
        student.addContent(nickname);
        student.addContent(marks);
        root.addContent(student);

        //第二个学生
        student = new Element("student");
        student.setAttribute(new Attribute("rollno", "2"));
        firstname = new Element("firstname", namespace).setText("cxx2");
        lastname = new Element("lastname").setText("Bob2");
        nickname = new Element("nickname").setText("stars2");
        marks = new Element("marks").setText("85");

        student.addContent(firstname);
        student.addContent(lastname);
        student.addContent(nickname);
        student.addContent(marks);
        root.addContent(student);

        //第三个学生
        student = new Element("student");
        student.setAttribute(new Attribute("rollno", "3"));
        firstname = new Element("firstname", namespace).setText("cxx3");
        lastname = new Element("lastname").setText("Bob3");
        nickname = new Element("nickname").setText("stars3");
        marks = new Element("marks").setText("85");

        student.addContent(firstname);
        student.addContent(lastname);
        student.addContent(nickname);
        student.addContent(marks);
        root.addContent(student);

        XMLOutputter xmlOutput = new XMLOutputter();
        //xml格式化
        Format format = Format.getRawFormat();
        //文本缩进
        format.setIndent("  ");
        format.setTextMode(Format.TextMode.TRIM_FULL_WHITE);
        xmlOutput.setFormat(format);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        xmlOutput.output(document, out);
        logger.info(out.toString());
    }
}
