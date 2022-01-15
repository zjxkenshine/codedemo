package com.kenshine.jsonlib.test;

import com.kenshine.jsonlib.model.Student;
import net.sf.json.JSONArray;
import net.sf.json.JSONSerializer;

import java.util.List;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/15 9:03
 * @description：JSON转集合
 * @modified By：
 * @version: $
 */
public class Test07_JsonToCollections {
    public static void main(String[] args) {
        String json1 = "['first','second']";
        JSONArray jsonArray1 = (JSONArray) JSONSerializer.toJSON(json1);
        List output1 = (List) JSONSerializer.toJava(jsonArray1);
        System.out.println("List");
        System.out.println(output1.get(0));


        String json2 = "[{'age':10,'sex':'男','userName':'xiapi1'},{'age':11,'sex':'女','userName':'xiapi2'}]";
        JSONArray jsonArray2 = JSONArray.fromObject(json2);
        List<Student> output2 = JSONArray.toList(jsonArray2,Student.class);
        System.out.println("List<Student>");
        System.out.println(output2.size());
        System.out.println(output2.get(0));
        System.out.println(output2.get(0).getUserName());
    }
}
