package com.kenshine.jsonlib.test;

import com.kenshine.jsonlib.model.Student;
import net.sf.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/15 8:54
 * @description：
 * @modified By：
 * @version: $
 */
public class Test03_MapToJson {
    public static void main(String[] args) {
        Map map1 = new HashMap();
        map1.put("name", "json");
        map1.put("bool", Boolean.TRUE);
        map1.put("int", new Integer(1));
        map1.put("arr", new String[]{"a", "b"});
        map1.put("func", "function(i){ return this.arr[i]; }");
        JSONObject jsonObject1 = JSONObject.fromObject(map1);
        System.out.println("Map map1");
        System.out.println(jsonObject1);

        Map<String, Student> map2 = new HashMap<>();
        map2.put("k1", new Student("kenshine1", "男", 10));
        map2.put("k2", new Student("kenshine2", "女", 12));
        map2.put("k3", new Student("kenshine3", "男", 13));
        JSONObject jsonObject2 = JSONObject.fromObject(map2);
        System.out.println("Map<String,Student> map2");
        System.out.println(jsonObject2);
    }
}
