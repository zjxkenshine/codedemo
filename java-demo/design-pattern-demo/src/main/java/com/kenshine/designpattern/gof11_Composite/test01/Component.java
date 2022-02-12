package com.kenshine.designpattern.gof11_Composite.test01;

/**
 * @author ：kenshine
 * @date ：Created in 2022/2/12 19:39
 * @description：抽象构建(接口)
 * @modified By：
 * @version: $
 */
public interface Component {
    void add(Component c);
    void remove(Component c);
    Component getChild(int i);
    // 通用操作
    void operation();
}
