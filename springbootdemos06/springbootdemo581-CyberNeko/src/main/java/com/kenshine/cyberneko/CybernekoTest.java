package com.kenshine.cyberneko;

import org.apache.html.dom.HTMLDocumentImpl;
import org.apache.xerces.parsers.XMLParser;
import org.apache.xerces.xni.parser.XMLDocumentFilter;
import org.apache.xerces.xni.parser.XMLInputSource;
import org.apache.xerces.xni.parser.XMLParserConfiguration;
import org.cyberneko.html.HTMLConfiguration;
import org.cyberneko.html.filters.ElementRemover;
import org.cyberneko.html.parsers.DOMFragmentParser;
import org.cyberneko.html.parsers.DOMParser;
import org.junit.Test;
import org.w3c.dom.DocumentFragment;
import org.w3c.dom.Node;
import org.w3c.dom.html.HTMLDocument;
import org.xml.sax.SAXException;

import java.io.IOException;

/**
 * @author by kenshine
 * @Classname CybernekoTest
 * @Description CybernekoHTML解析测试
 * @Date 2023-12-14 20:00
 * @modified By：
 * @version: 1.0$
 */
public class CybernekoTest {

    /**
     * 快速解析 DOMParser
     */
    @Test
    public void test01() throws IOException, SAXException {
        DOMParser parser = new DOMParser();
        parser.parse("html\\test01.html");
        print(parser.getDocument(), "");
    }

    /**
     * DOMFragmentParser 解析为dom节点
     */
    @Test
    public void test02() throws IOException, SAXException {
        DOMFragmentParser parser = new DOMFragmentParser();
        HTMLDocument document = new HTMLDocumentImpl();
        DocumentFragment fragment = document.createDocumentFragment();
        parser.parse("html\\test01.html", fragment);
        print(fragment, "");
    }

    /**
     * 自定义解析器
     */
    @Test
    public void test03() throws IOException, SAXException {
        HTMLSAXParser parser = new HTMLSAXParser(new HTMLConfiguration());
        parser.parse("html\\test01.html");
    }

    /**
     * 过滤元素
     */
    @Test
    public void test04() throws IOException {
        // 移除过滤器
        ElementRemover remover = new ElementRemover();

        // 设置可以接受的元素
        remover.acceptElement("b", null);
        remover.acceptElement("i", null);
        remover.acceptElement("u", null);
        remover.acceptElement("a", new String[] { "href" });

        // 删除Script院所
        remover.removeElement("script");

        // 写过滤器
        org.cyberneko.html.filters.Writer writer = new org.cyberneko.html.filters.Writer();

        // 设置过滤器
        XMLDocumentFilter[] filters = {
                remover,
                writer,
        };

        // 创建HTML解析器
        XMLParserConfiguration parser = new HTMLConfiguration();
        parser.setProperty("http://cyberneko.org/html/properties/filters", filters);
        String systemId = "html\\test01.html";
        XMLInputSource source = new XMLInputSource(null, systemId, null);
        parser.parse(source);
    }

    public static void print(Node node, String indent) {
        System.out.println(indent+node.getClass().getName());
        Node child = node.getFirstChild();
        while (child != null) {
            print(child, indent+" ");
            child = child.getNextSibling();
        }
    }
}
