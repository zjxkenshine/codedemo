package com.kenshine.jsonlib.test;

import com.kenshine.jsonlib.model.Class;
import com.kenshine.jsonlib.model.Student;
import net.sf.ezmorph.MorpherRegistry;
import net.sf.ezmorph.object.DateMorpher;
import net.sf.json.JSONObject;
import net.sf.json.util.JSONUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/15 9:07
 * @description：JSon转javaBean
 * @modified By：
 * @version: $
 */
public class Test09_JsonToBean {
    public static void main(String[] args) {
        //简单对象
        String json1 = "{'age':22,'sex':'男','userName':'kenshine'}";
        JSONObject jsonObject1 = JSONObject.fromObject(json1);
        Student output1 = (Student)JSONObject.toBean(jsonObject1,Student.class);
        System.out.println("Student");
        System.out.println(output1.getUserName());

        //复杂对象
        String json2 = "{'date':'2012-05-21 13:03:11','name':'土木工程','students':[{'age':20,'sex':'男','userName':'kenshine'},{'age':18,'sex':'女','userName':'qin'}]}";

        //转为日期
        String[] DATE_FORMAT = { "yyyy-MM-dd HH:mm:ss" };
        MorpherRegistry morpherRegistry = JSONUtils.getMorpherRegistry();
        morpherRegistry.registerMorpher(new DateMorpher(DATE_FORMAT));
        JSONObject jsonObject2 = JSONObject.fromObject(json2);

        Map typeMap1 = new HashMap();
        typeMap1.put("date", Date.class);
        typeMap1.put("name",String.class);
        typeMap1.put("students", Student .class);

        Class output2 = (Class) JSONObject.toBean(jsonObject2,Class.class,typeMap1);
        System.out.println("Class");
        System.out.println(output2.getName());
        System.out.println(output2.getDate());
        System.out.println(output2.getStudents().get(0).getUserName());
    }
}
