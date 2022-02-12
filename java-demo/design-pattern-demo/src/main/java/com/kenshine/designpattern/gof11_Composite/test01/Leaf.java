package com.kenshine.designpattern.gof11_Composite.test01;

/**
 * @author ：kenshine
 * @date ：Created in 2022/2/12 19:40
 * @description：叶子类
 * @modified By：
 * @version: $
 */
public class Leaf implements Component{
    private String name;
    public Leaf(String name) {
        this.name = name;
    }
    public void add(Component c) {
    }
    public void remove(Component c) {
    }
    public Component getChild(int i) {
        return null;
    }
    // 操作
    public void operation() {
        System.out.println("树叶" + name + "：被访问！");
    }
}
