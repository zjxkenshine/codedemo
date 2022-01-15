package com.kenshine.jsonlib.test;

import com.kenshine.jsonlib.model.Student;
import net.sf.ezmorph.Morpher;
import net.sf.ezmorph.MorpherRegistry;
import net.sf.ezmorph.bean.BeanMorpher;
import net.sf.json.JSONObject;
import net.sf.json.util.JSONUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/15 9:05
 * @description：JSON转map
 * @modified By：
 * @version: $
 */
public class Test08_JsonToMap {
    public static void main(String[] args) {
        String json1 ="{'arr':['a','b'],'int':1,'name':'json','bool':true}";
        JSONObject jsonObject1 = JSONObject.fromObject(json1);

        Map typeMap1 = new HashMap();
        typeMap1.put("arr", String[].class);
        typeMap1.put("int", Integer.class);
        typeMap1.put("name", String.class);
        typeMap1.put("bool", Boolean.class);

        Map output1 = (Map)JSONObject.toBean(jsonObject1, Map.class,typeMap1);
        System.out.println("Map");
        System.out.println(output1.size());
        System.out.println(output1.get("name"));
        System.out.println(output1.get("arr"));

        String json2 ="{'k1':{'age':10,'sex':'男','userName':'kenshine1'},'k2':{'age':12,'sex':'女','userName':'kenshine2'}}";
        JSONObject jsonObject2 = JSONObject.fromObject(json2);
        Map<String,Class<?>> typeMap2 =new HashMap<>();
        Map<String, Student> output2 = (Map<String,Student>)JSONObject.toBean(jsonObject2,Map.class,typeMap2);
        System.out.println("Map<String,Student>");
        System.out.println(output2.size());
        System.out.println(output2.get("k1"));

        //先往注册器中注册变换器，需要用到ezmorph包中的类
        MorpherRegistry morpherRegistry = JSONUtils.getMorpherRegistry();
        Morpher dynaMorpher = new BeanMorpher(Student.class,morpherRegistry);
        morpherRegistry.registerMorpher(dynaMorpher);
        System.out.println(((Student)morpherRegistry.morph(Student.class,output2.get("k2"))).getUserName());
    }
}
