package com.kenshine.nekopull;

import org.apache.xerces.xni.parser.XMLInputSource;
import org.cyberneko.pull.XMLEvent;
import org.cyberneko.pull.XMLPullParser;
import org.cyberneko.pull.event.CharactersEvent;
import org.cyberneko.pull.event.ElementEvent;
import org.cyberneko.pull.parsers.Xerces2;
import org.junit.Test;

import java.io.IOException;

/**
 * @author by kenshine
 * @Classname NekopullTest
 * @Description Nekopull使用测试
 * @Date 2023-12-14 21:11
 * @modified By：
 * @version: 1.0$
 */
public class NekopullTest {

    /**
     * 解析XML
     */
    @Test
    public void test() throws IOException {
        XMLPullParser parser = new Xerces2();
        XMLInputSource source = new XMLInputSource(null, "xml\\test01.xml", null);
        parser.setInputSource(source);

        // 遍历元素
        XMLEvent event;
        while ((event = parser.nextEvent()) != null) {
            if (event.type == XMLEvent.ELEMENT) {
                ElementEvent elementEvent = (ElementEvent)event;
                if (elementEvent.start) {
                    System.out.println("("+elementEvent.element.rawname);
                }
                else {
                    System.out.println(")"+elementEvent.element.rawname);
                }
            }
            else if (event.type == XMLEvent.CHARACTERS) {
                CharactersEvent charsEvent = (CharactersEvent)event;
                System.out.println("\""+charsEvent.text);
            }
        }
        // 释放
        parser.cleanup();
    }
}
