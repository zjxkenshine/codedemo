package com.kenshine.profile.demo;

import lombok.Data;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/3 18:33
 * @description：
 * @modified By：
 * @version: $
 */
@Data
public class Demo {
    private String env;

    public Demo(String demo){
        System.out.println(demo+"构造器被执行了!");
        this.env=demo;
    }

}
