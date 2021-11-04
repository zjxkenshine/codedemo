package com.kenshine.pattern.singleton.demo09;

import java.lang.reflect.Constructor;

/**
 * @version v1.0
 * @ClassName: Client
 * @Description:
 *      测试使用反射破坏单例模式
 * @Author: 黑马程序员
 */
public class Client {
    public static void main(String[] args) throws Exception {
        //1,获取Singleton的字节码对象
        Class clazz = Singleton.class;
        //2,获取无参构造方法对象
        Constructor cons = clazz.getDeclaredConstructor();
        //3,取消访问检查
        cons.setAccessible(true);
        //4,创建Singleton对象 通过反射
        Singleton s1 = (Singleton) cons.newInstance();
        Singleton s2 = (Singleton) cons.newInstance();

        System.out.println(s1 == s2); //如果返回的是true，说明并没有破坏单例模式，如果是false，说明破坏了单例模式
    }
}
