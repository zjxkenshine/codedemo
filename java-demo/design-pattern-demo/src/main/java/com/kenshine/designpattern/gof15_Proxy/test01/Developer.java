package com.kenshine.designpattern.gof15_Proxy.test01;

/**
 * @author ：kenshine
 * @date ：Created in 2022/2/20 19:38
 * @description：真实类
 * @modified By：
 * @version: $
 */
public class Developer implements IDeveloper{
    private String name;
    public Developer(String name){
        this.name = name;
    }
    @Override
    public void writeCode() {
        System.out.println("Developer " + name + " writes code");
    }
}
