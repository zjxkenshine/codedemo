package com.kenshine.jericho;

import au.id.jericho.lib.html.Element;
import au.id.jericho.lib.html.Source;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author by kenshine
 * @Classname JerichoTest
 * @Description 解析HTML
 * @Date 2024-03-09 13:28
 * @modified By：
 * @version: 1.0$
 */
public class JerichoTest {

    /**
     * 解析HTML
     */
    @Test
    public void test(){
        String path = "html\\test01.html";
        try {
            Source sc = new Source(new FileInputStream(path));
            Element element = sc.findNextElement(1);
            System.out.println(element.extractText());
            System.out.println(sc.extractText());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
