package com.kenshine.designpattern.gof01_Singleton.test01;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/9 23:27
 * @description：单例模式
 * @modified By：
 * @version: $
 */
public class Single {
    private static final Single single = new Single();
    //限制产生多个对象
    private Single(){}
    //通过该方法获得实例对象
    private static Single getInstance(){
        return single;
    }
    //类中其他方法，尽量是static
    public static void doSomething(){
    }
}
