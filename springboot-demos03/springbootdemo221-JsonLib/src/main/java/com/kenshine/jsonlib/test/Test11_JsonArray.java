package com.kenshine.jsonlib.test;

import net.sf.json.JSONArray;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/15 9:12
 * @description：JsonArray测试
 * @modified By：
 * @version: $
 */
public class Test11_JsonArray {
    public static void main(String[] args) {
        JSONArray jsonArray = new JSONArray();
        jsonArray.add(0,"第一个值");
        jsonArray.add(1,"第二个值");
        jsonArray.add(2,"第三个值");
        System.out.print(jsonArray.toString());
    }
}
