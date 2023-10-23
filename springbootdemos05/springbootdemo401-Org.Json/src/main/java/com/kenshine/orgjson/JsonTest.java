package com.kenshine.orgjson;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;

/**
 * @author by kenshine
 * @Classname JsonTest
 * @Description 测试
 * @Date 2023-10-23 9:54
 * @modified By：
 * @version: 1.0$
 */
public class JsonTest {
    /**
     * 测试JsonObject
     */
    @Test
    public void testJsonObject(){
        //JSON
        String json = "jQuery6({\n" +
                "\t\"id\":\"07\",\n" +
                "\t\"language\":\"C++\",\n" +
                "\t\"edition\":\"second\",\n" +
                "\t\"author\":\"kenshine\"\n" +
                "})";
        //预处理
        String attr = json.split("\\(")[1];
        attr = attr.substring(0,attr.length()-1);
        //解析
        JSONObject jsonObject = new JSONObject(attr);
        System.out.println(jsonObject.getString("id"));
        System.out.println(jsonObject.getString("language"));
        System.out.println(jsonObject.getString("edition"));
        System.out.println(jsonObject.getString("author"));
    }

    /**
     * 测试JsonArray
     */
    @Test
    public void testJsonArray(){
        //JSON
        String json = "jQuery6([{\n" +
                "\t\"id\":\"07\",\n" +
                "\t\"language\":\"C++\",\n" +
                "\t\"edition\":\"second\",\n" +
                "\t\"author\":\"kenshine1\"\n" +
                "},{\n" +
                "\t\"id\":\"08\",\n" +
                "\t\"language\":\"C++\",\n" +
                "\t\"edition\":\"second\",\n" +
                "\t\"author\":\"kenshine2\"\n" +
                "}])";
        //预处理
        String attr = json.split("\\(")[1];
        attr = attr.substring(0,attr.length()-1);
        //解析
        JSONArray jsonArray = new JSONArray(attr);
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            System.out.println(jsonObject.getString("id"));
            System.out.println(jsonObject.getString("language"));
            System.out.println(jsonObject.getString("edition"));
            System.out.println(jsonObject.getString("author"));
            System.out.println();
        }
    }


}
