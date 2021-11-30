package domxml;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.namespace.NamespaceContext;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;
import java.io.ByteArrayOutputStream;
import java.util.Iterator;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/30 17:41
 * @description：
 * @modified By：
 * @version: $
 */
public class DomCase {
    private static Logger logger = LoggerFactory.getLogger(DomCase.class);

    /**
     * 解析xml
     * @throws Exception
     */
    @Test
    public void parse() throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        //支持命名空间
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        //解析xml文件为文档
        Document document = builder.parse(DomCase.class.getClassLoader().getResourceAsStream("xml/demo129.xml"));
        Element rootElement = document.getDocumentElement();
        NodeList list = rootElement.getChildNodes();//所有学生
//        NodeList list = document.getElementsByTagName("school:student"); //第1个学生
//        NodeList list = document.getElementsByTagName("student"); //第2、3的学生
//        NodeList list = document.getElementsByTagNameNS("http://www.w3.org/TR/html4/school/", "student");//第1个学生
        for (int i = 0; i < list.getLength(); i++) {
            Node node = list.item(i);
            if (node.getNodeType() != Node.ELEMENT_NODE) {
                continue;
            }
            logger.info("学生编号" + node.getAttributes().getNamedItem("rollno").getTextContent());
            if (node.getAttributes().getNamedItem("school:age") != null) {
                logger.info("age=" + node.getAttributes().getNamedItem("school:age").getTextContent());
            }
            NodeList childNodes = node.getChildNodes();
            for (int j = 0; j < childNodes.getLength() ; j++) {
                Node childNode = childNodes.item(j);
                if (childNode.getNodeType() == Node.ELEMENT_NODE) {
                    logger.info(childNode.getNodeName() + ":" + childNode.getFirstChild().getNodeValue());
                }
            }
        }
    }

    /**
     * xpath使用
     * XPath 是一门在 XML 文档中查找信息的语言。XPath 可用来在 XML 文档中对元素和属性进行遍历
     * XPath 是 W3C XSLT 标准的主要元素，并且 XQuery 和 XPointer 都构建于 XPath 表达之上
     * @throws Exception
     */
    @Test
    public void xpath() throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        //支持命名空间
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        //解析xml文件为文档
        Document document = builder.parse(DomCase.class.getClassLoader().getResourceAsStream("xml/demo129.xml"));

        XPathFactory xPathFactory = XPathFactory.newInstance();
        XPath xpath = xPathFactory.newXPath();
        xpath.setNamespaceContext(new NamespaceContext() {
            /**
             * 根据前缀获取命名空间
             * @param prefix
             * @return
             */
            @Override
            public String getNamespaceURI(String prefix) {
                if ("school".equals(prefix)) {
                    return "http://www.w3.org/TR/html4/school/";
                }
                return null;
            }

            @Override
            public String getPrefix(String namespaceURI) {
                return null;
            }

            @Override
            public Iterator getPrefixes(String namespaceURI) {
                return null;
            }
        });

        logger.info("查找所有的存在rollno属性的student节点，取出lastname的值");
        XPathExpression expr = xpath.compile("//student[@rollno]/lastname/text()");//第2、3位学生
//        XPathExpression expr = xpath.compile("//student[@rollno]/child::lastname/text()");//效果同上
//        XPathExpression expr = xpath.compile("//school:student[@rollno]/lastname/text()");//第1位学生
        Object result = expr.evaluate(document, XPathConstants.NODESET);
        NodeList nodes = (NodeList) result;
        for (int i = 0; i < nodes.getLength(); i++) {
            logger.info(nodes.item(i).getNodeValue());
        }
    }

    /**
     * 生成xml
     */
    @Test
    public void toXml() throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        //新建一个文档对象
        Document document = builder.newDocument();
        //createElementNS() 方法可创建带有指定命名空间的元素节点。
        //此方法可返回一个 Element 对象
        Element elementClass = document.createElementNS("http://www.w3.org/TR/html4/school/", "school:class");

        //第一个学生
        Element elementStudent1 = document.createElement("student");
        //setAttribute() 方法创建或改变某个新属性
        elementStudent1.setAttribute("rollno", "1");
        //setAttributeNS() 方法创建或改变具有命名空间的属性
        elementStudent1.setAttributeNS("http://www.w3.org/TR/html4/school/", "school:age", "10");

        Element elementFirstname1 = document.createElement("school:firstname");
        elementFirstname1.setTextContent("cxx1");
        Element elementLastname1 = document.createElement("lastname");
        elementLastname1.setTextContent("Bob1");
        Element elementNickname1 = document.createElement("nickname");
        elementNickname1.setTextContent("stars1");
        Element elementMarks1 = document.createElement("marks");
        elementMarks1.setTextContent("85");

        //appendChild() 方法在指定元素节点的最后一个子节点之后添加节点
        elementStudent1.appendChild(elementFirstname1);
        elementStudent1.appendChild(elementLastname1);
        elementStudent1.appendChild(elementNickname1);
        elementStudent1.appendChild(elementMarks1);
        elementClass.appendChild(elementStudent1);

        //第二个学生
        Element elementStudent2 = document.createElement("student");
        elementStudent2.setAttribute("rollno", "2");

        Element elementFirstname2 = document.createElement("firstname");
        elementFirstname2.setTextContent("cxx2");
        Element elementLastname2 = document.createElement("lastname");
        elementLastname2.setTextContent("Bob2");
        Element elementNickname2 = document.createElement("nickname");
        elementNickname2.setTextContent("stars2");
        Element elementMarks2 = document.createElement("marks");
        elementMarks2.setTextContent("85");

        elementStudent2.appendChild(elementFirstname2);
        elementStudent2.appendChild(elementLastname2);
        elementStudent2.appendChild(elementNickname2);
        elementStudent2.appendChild(elementMarks2);
        elementClass.appendChild(elementStudent2);

        //第三个学生
        Element elementStudent3 = document.createElement("student");
        elementStudent3.setAttribute("rollno", "3");

        Element elementFirstname3 = document.createElement("firstname");
        elementFirstname3.setTextContent("cxx3");
        Element elementLastname3 = document.createElement("lastname");
        elementLastname3.setTextContent("Bob3");
        Element elementNickname3 = document.createElement("nickname");
        elementNickname3.setTextContent("stars3");
        Element elementMarks3 = document.createElement("marks");
        elementMarks3.setTextContent("85");

        elementStudent3.appendChild(elementFirstname3);
        elementStudent3.appendChild(elementLastname3);
        elementStudent3.appendChild(elementNickname3);
        elementStudent3.appendChild(elementMarks3);
        elementClass.appendChild(elementStudent3);

        document.appendChild(elementClass);

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.ENCODING,"utf-8");
        //换行
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        DOMSource domSource = new DOMSource(document);

        //xml输出到的地方
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        StreamResult streamResult = new StreamResult(out);
        transformer.transform(domSource, streamResult);
        logger.info(out.toString());
    }
}
