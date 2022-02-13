package com.kenshine.designpattern.gof14_Flyweight.test01;

/**
 * @author ：kenshine
 * @date ：Created in 2022/2/13 21:31
 * @description：《设计模式之禅》示例
 * @modified By：
 * @version: $
 */
public class Client {
    public static void main(String[] args) {
        for (int i = 0; i < 4; i++) {
            String key = "test" + i;
            FlyweightFactory.getFlyweight(key);
        }
        Flyweight flyweight = FlyweightFactory.getFlyweight("test0");
        if(flyweight != null){
            flyweight.operate();
        }else{
            flyweight.operate();
        }
    }
}
