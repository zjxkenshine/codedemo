package com.kenshine.jsonlib.test;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/15 9:13
 * @description：JsonObject测试
 * @modified By：
 * @version: $
 */
public class Test12_JsonObject {
    public static void main(String[] args) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "kenshine");
        jsonObject.put("age", 20);
        jsonObject.put("sex", "男");
        JSONArray jsonArray = new JSONArray();
        jsonArray.add("唱歌");
        jsonArray.add("摄影");
        jsonArray.add("象棋");
        jsonObject.element("hobby",jsonArray);
        System.out.println(jsonObject);
    }
}
