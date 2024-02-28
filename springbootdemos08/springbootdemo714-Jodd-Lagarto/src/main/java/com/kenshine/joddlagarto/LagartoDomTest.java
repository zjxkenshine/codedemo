package com.kenshine.joddlagarto;

import jodd.lagarto.dom.Document;
import jodd.lagarto.dom.LagartoDOMBuilder;
import jodd.lagarto.dom.Node;
import jodd.lagarto.dom.Text;
import org.junit.Test;

/**
 * @author by kenshine
 * @Classname LagartoDomTest
 * @Description LagartoDom 解析HTML并构建DOM树
 * @Date 2024-02-28 12:23
 * @modified By：
 * @version: 1.0$
 */
public class LagartoDomTest {

    /**
     * 解析HTML并构建DOM树
     */
    @Test
    public void test01(){
        Document document = new LagartoDOMBuilder()
                .parse("<html><h1>Hello</h1></html>");
        Node html = document.getChild(0);
        Node h1 = html.getFirstChild();
        System.out.println(h1.getTextContent());

        Text text = (Text) h1.getFirstChild();
        System.out.println(text.getTextValue());

        System.out.println(text.getCssPath());
    }
}
