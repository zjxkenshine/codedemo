package com.kenshine.festreflect.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author by kenshine
 * @Classname User
 * @Description 测试类
 * @Date 2023-12-05 16:12
 * @modified By：
 * @version: 1.0$
 */
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User extends UserBase{
    public static int count = 1;
    public static List<String> commonPowers = Arrays.asList("static","static1");

    private Integer id;
    private String name;

    private List<String> powers;

    public User(String name){
        this.name=name;
    }

    public void concentrate(){
        System.out.println("调用了concentrate方法");
    }

    public static void setCommonPower(String power){
        commonPowers = Collections.singletonList(power);
    }

    public static List<String> getCommonPowers(){
        return commonPowers;
    }

    public static void addPadawan(){
        System.out.println("调用了addPadawan方法");
    }

    public static String commonPowerCount(){
        return "test";
    }
}
