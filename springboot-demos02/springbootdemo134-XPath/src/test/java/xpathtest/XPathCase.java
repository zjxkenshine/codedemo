package xpathtest;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import javax.xml.namespace.NamespaceContext;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;
import java.util.Iterator;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/1 9:15
 * @description：Xpath使用
 * @modified By：
 * @version: $
 */
public class XPathCase {

    private static Logger logger = LoggerFactory.getLogger(XPathCase.class);

    @Test
    public void xpath() throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        //支持命名空间
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        //解析xml文件为文档
        Document document = builder.parse(XPathCase.class.getClassLoader().getResourceAsStream("xml/demo134.xml"));

        XPathFactory xPathFactory = XPathFactory.newInstance();
        XPath xpath = xPathFactory.newXPath();
        xpath.setNamespaceContext(new NamespaceContext() {
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
}
