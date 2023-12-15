package com.kenshine.dtdparser;

import com.wutka.dtd.DTD;
import com.wutka.dtd.DTDElement;
import com.wutka.dtd.DTDParser;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Enumeration;

/**
 * @author by kenshine
 * @Classname DtdTest
 * @Description 使用测试
 * @Date 2023-12-15 16:19
 * @modified By：
 * @version: 1.0$
 */
public class DtdTest {

    /**
     * wutka.dtd.DTDParser 解析DTD
     */
    @Test
    public void test01() throws IOException {
        String result = null;
        File dtd = new File("dtd\\test.dtd");
        DTDParser parser = new DTDParser(dtd);
        DTD d = parser.parse(true);
        if (d != null) {
            if (d.rootElement != null) {
                result = d.rootElement.getName();
                System.out.println(result);
            }
        }
        Enumeration enumeration=d.elements.elements();
        while (enumeration.hasMoreElements()){
            System.out.println(((DTDElement)enumeration.nextElement()).getName());
        }
    }
}
