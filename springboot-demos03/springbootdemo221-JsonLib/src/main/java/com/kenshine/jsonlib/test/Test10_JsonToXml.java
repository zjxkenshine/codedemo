package com.kenshine.jsonlib.test;

import net.sf.json.JSONObject;
import net.sf.json.xml.XMLSerializer;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/15 9:11
 * @description：JSON转XML
 * @modified By：
 * @version: $
 *
 * XMLSerializer
 */
public class Test10_JsonToXml {
    public static void main(String[] args) {
        String json1 = "{'age':22,'sex':'男','userName':'kenshine'}";
        JSONObject jsonObj = JSONObject.fromObject(json1);
        XMLSerializer x = new XMLSerializer();
        String xml = x.write(jsonObj);
        System.out.println("XML");
        System.out.println(xml);
    }
}
