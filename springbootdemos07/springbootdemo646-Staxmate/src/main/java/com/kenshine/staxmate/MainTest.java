package com.kenshine.staxmate;

import com.kenshine.staxmate.model.Food;

import javax.xml.stream.XMLStreamException;

/**
 * @author by kenshine
 * @Classname MainTest
 * @Description 测试
 * @Date 2024-01-02 10:31
 * @modified By：
 * @version: 1.0$
 */
public class MainTest {

    public static void main(String[] args) throws XMLStreamException {
        MeatXmlParser parser = new MeatXmlParser();
        // 解析xml
        Food food=parser.parse(MainTest.class.getResourceAsStream("/test.xml"));
        System.out.println(food);
    }
}
