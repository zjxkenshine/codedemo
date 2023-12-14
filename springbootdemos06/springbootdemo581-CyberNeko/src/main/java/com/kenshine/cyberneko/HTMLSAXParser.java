package com.kenshine.cyberneko;

import org.apache.xerces.parsers.AbstractSAXParser;
import org.apache.xerces.xni.parser.XMLParserConfiguration;

/**
 * @author by kenshine
 * @Classname HTMLSAXParser
 * @Description 自定义解析器
 * @Date 2023-12-14 20:24
 * @modified By：
 * @version: 1.0$
 */
public class HTMLSAXParser extends AbstractSAXParser {
    protected HTMLSAXParser(XMLParserConfiguration xmlParserConfiguration) {
        super(xmlParserConfiguration);
        System.out.println("执行解析");
    }
}
