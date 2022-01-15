package com.kenshine.jsonlib.test;

import net.sf.json.JSON;
import net.sf.json.xml.XMLSerializer;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/15 8:59
 * @description：
 * @modified By：
 * @version: $
 */
public class Test05_XmlToJson {
    public static void main(String[] args) {
        String s="<student>\n" +
                "                <name id='n1'>kenshine</name>\n" +
                "                        <sex class='s1'>男</sex>\n" +
                "                        <age>20</age>\n" +
                "                    </student>";
        XMLSerializer x =new XMLSerializer();
        JSON json = x.read(s);
        System.out.println("XmlToJson");
        System.out.println(json.toString());
    }
}
