package com.kenshine.kryo.demo02;

import java.io.Serializable;
import java.util.Map;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/18 15:10
 * @description：实体类
 * @modified By：
 * @version: $
 */
public class Simple implements Serializable {
    private static final long serialVersionUID = -4914434736682797743L;
    private String name;
    private int age;
    private Map<String,Integer> map;
    public Simple(){

    }
    public Simple(String name,int age,Map<String,Integer> map){
        this.name = name;
        this.age = age;
        this.map = map;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Map<String, Integer> getMap() {
        return map;
    }

    public void setMap(Map<String, Integer> map) {
        this.map = map;
    }
}
