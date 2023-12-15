package com.kenshine.sumdtdparser;

import com.sun.xml.dtdparser.DTDEventListener;
import com.sun.xml.dtdparser.DTDHandlerBase;
import com.sun.xml.dtdparser.DTDParser;
import org.junit.Test;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;

/**
 * @author by kenshine
 * @Classname DtdParserTest
 * @Description com.sun.xml.dtd-parser 使用测试
 * @Date 2023-12-15 14:58
 * @modified By：
 * @version: 1.0$
 */
public class DtdParserTest {

    /**
     * 简单解析
     */
    @Test
    public void test01() throws IOException, SAXException {
        Map<String, Short> attributes = new HashMap<>();
        StringBuilder dtd = new StringBuilder();
        dtd.append("  <!ELEMENT root EMPTY>");
        dtd.append("  <!ATTLIST root\n");
        dtd.append("    normal CDATA \"default\"");
        dtd.append("    implied CDATA #IMPLIED");
        dtd.append("    required CDATA #REQUIRED");
        dtd.append("    fixed CDATA #FIXED \"default\"");
        dtd.append("  >");

        DTDEventListener handler = new DTDHandlerBase() {
            @Override
            public void attributeDecl(String element, String name, String type, String[] enums, short use, String defaultValue) {
                attributes.put(name, use);
            }
        };
        InputSource input = new InputSource(new StringReader(dtd.toString()));
        DTDParser parser = new DTDParser();
        parser.setDtdHandler(handler);
        parser.parse(input);
        System.out.println(attributes);
    }

    /**
     * 设置Handler,读取文件
     */
    @Test
    public void test02() throws IOException, SAXException {
        Map<String, Short> attributes = new HashMap<>();
        DTDParser dtdParser = new DTDParser();
        // 处理器设置
        dtdParser.setDtdHandler(new DTDHandlerBase(){
            @Override
            public void processingInstruction(String target, String data){
                System.out.println(target);
                System.out.println(data);
            }

            @Override
            public void attributeDecl(String element, String name, String type, String[] enums, short use, String defaultValue) {
                attributes.put(name, use);
            }
        });
        dtdParser.parse(new InputSource(new FileInputStream("dtd\\test.dtd")));
        System.out.println(attributes);
    }
}
