package com.kenshine.jsonlib.test;

import net.sf.ezmorph.test.ArrayAssertions;
import net.sf.json.JSONArray;
import net.sf.json.JSONSerializer;
import net.sf.json.JsonConfig;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/15 9:00
 * @description：JSON转数组
 * @modified By：
 * @version: $
 */
public class Test06_JsonToArrays {
    public static void main(String[] args) {
        String json1 = "['first','second']";
        JSONArray jsonArray1 = (JSONArray) JSONSerializer.toJSON(json1);
        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.setArrayMode(JsonConfig.MODE_OBJECT_ARRAY);
        Object[] output1 = (Object[]) JSONSerializer.toJava(jsonArray1, jsonConfig);
        Object[] expected = new Object[]{"first", "second"};
        ArrayAssertions.assertEquals(expected, output1);
        System.out.println("Object[]");
        System.out.println(output1.length);
        System.out.println(output1[1]);

        String json2 = "[[1,2],[3,4]]";
        JSONArray jsonArray2 = JSONArray.fromObject(json2);
        Object[][] output2 = (Object[][]) JSONArray.toArray(jsonArray2);
        System.out.println("Object[][]");
        System.out.println(output2.length);
        System.out.println(output2[0][0]);
    }
}
