package com.kenshine.pattern2.flyweight;

import javax.swing.*;
import java.util.HashMap;

/**
 * @version v1.0
 * @ClassName: BoxFactory
 * @Description: 享元工厂
 * @Author: 黑马程序员
 */
public class BoxFactory {

    private HashMap<String,AbstractBox> map;

    //在构造方法中进行初始化操作
    private BoxFactory() {
        map = new HashMap<String, AbstractBox>();
        map.put("I",new IBox());
        map.put("L",new LBox());
        map.put("O",new OBox());
    }

    //提供一个方法获取该工厂类对象
    public static BoxFactory getInstance() {
        return factory;
    }

    private static BoxFactory factory = new BoxFactory();

    //根据名称获取图形对象
    public AbstractBox getShape(String name) {
        return map.get(name);
    }
}
